package model.card;

import java.util.ArrayList;

import model.card.standard.Ace;
import model.card.standard.Jack;
import model.card.standard.King;
import model.card.standard.Queen;
import model.card.standard.Standard;
import model.card.wild.Burner;
import model.card.wild.Saver;

import java.io.*;
import java.util.*;

public class Deck {
	private static final String CARDS_FILE = "../Cards.csv";
	private static ArrayList<Card> cardsPool = new ArrayList<>();

	public static void loadCardPool(BoardManager boardManager, GameManager gameManager) throws IOException {
		BufferedReader reader = null;
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(CARDS_FILE));
			reader.readLine(); 

			while ((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				if (row.length < 6) continue; // Ensure valid data

				int code = Integer.parseInt(row[0].trim());
				int frequency = Integer.parseInt(row[1].trim());
				String name = row[2].trim();
				String description = row[3].trim();
				int rank = row[4].trim().isEmpty() ? -1 : Integer.parseInt(row[4].trim()); // Handle wild cards
				String suit = row[5].trim().isEmpty() ? null : row[5].trim();

				Card card;
				switch (name.toLowerCase()) {
				case "ace":
					card = new Ace(name, description, suit, boardManager, gameManager);
					break;
				case "king":
					card = new King(name, description, suit, boardManager, gameManager);
					break;
				case "queen":
					card = new Queen(name, description, suit, boardManager, gameManager);
					break;
				case "jack":
					card = new Jack(name, description, suit, boardManager, gameManager);
					break;
				case "burner":
					card = new Burner(name, description, boardManager, gameManager);
					break;
				case "saver":
					card = new Saver(name, description, boardManager, gameManager);
					break;
				default:
					card = new Standard(name, description, suit, boardManager, gameManager);
					break;
				}

				for (int i = 0; i < frequency; i++) {
					cardsPool.add(card);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
	
	public static ArrayList<Card> drawCards() {
        Collections.shuffle(cardsPool);
        ArrayList<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < 4 && !cardsPool.isEmpty(); i++) {
            drawnCards.add(cardsPool.remove(0));
        }
        return drawnCards;
    }
	
	
}

