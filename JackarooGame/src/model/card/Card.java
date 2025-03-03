package model.card;

public abstract class Card {

	private String name;
	private String description;
	protected BoardManager boardManager;
	protected GameManager gameManager;
	
	
	public Card(String name, String description, BoardManager boardManager, GameManager gameManager){
		this.name = name;
		this.description = description;
		this.boardManager = boardManager;
		this.gameManager = gameManager;
	}
}
