package engine.board;
import java.util.ArrayList;
import model.player.Colour;
public class SafeZone{
		 private final Colour colour;
		 private final ArrayList<Cell> cells;
		 public SafeZone(Colour colour){
			 this.colour=colour;
			 this.cells=new ArrayList<>();
			 for(int i=0;i<4;i++){
				 this.cells.add(new Cell(CellType.SafeZone));
				 
			 }
		 }
		public Colour getColour() {
			return colour;
		}
		public ArrayList<Cell> getCells() {
			return cells;
		}
}
