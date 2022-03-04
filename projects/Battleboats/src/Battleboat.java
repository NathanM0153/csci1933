import java.util.Random;

public class Battleboats {
	private int size;
	private boolean orientation;
	private Cell[] spaces;
	private boolean sunk;

	public boolean getOrientation() {
		return orientation();
	}

	public Cell[] getSpaces() {
		return spaces;
	}

	public void setSpaces(Cell[] cells) {
		this.spaces = cells;
	}

	public int getSize() {
		return size;
	}


	public boolean isSunk() {
		return sunk;
	}

	public Battleboat(int length) { //constructor
		//randompos generates a starting point for a boat
		double randompos = Math.random() * size; //Math.random sets a random double between 0 and 1
		int bound = getSize() - length; //sets furthest top-left coordinate a ship can start on
		int xorigin = randompos(bound); //sets origin coordinate
		int yorigin = randompos(bound);
		double orient = Math.random(); //determines if boat is horizontal or vertical
		if (orient > 0.5) { //vertical
			orientation = true;
			for (int i = 1; i < length; i++) { //loops 2 times for a 3-long ship, origin is already set?
				//ship is vertical
			} else if (orient <= 0.5) { //horizontal
				orientation = false;
				for (int i = 1; i < size; i++) { //loops 2 times for a 3-long ship
					//ship is horizontal
				} else{
					System.out.println("Something went wrong calculating orientation.")
				}
			}
		}
		//do something to set spaces???
}

