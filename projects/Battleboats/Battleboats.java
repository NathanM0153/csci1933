import java.util.Scanner;
import java.util.Random;

public class Battleboats {
	private int size() {

	}

	private boolean orientation() {
		double orient = Math.random(); //determines if boat is horizontal or vertical
		if (orient > 0.5) { //vertical
			return true;
		} else if (orient <= 0.5) { //horizontal
			return false;
		} else {
			System.out.println("Something went wrong calculating orientation.")
		}
	}

	private Cell[] spaces { //represents cells that a ship occupies

	}

	public boolean getOrientation() {
		return orientation();
	}

	public Cell[] getSpaces() {
		return spaces;
	}

	public void setSpaces(Cell[] cells) {
		this.cells = cells;
	}

	public int getSize() {
		return size();
	}

	public int randompos(int n) { //returns random position to place boat
		int position = Math.random() * n; //Math.random sets a random double between 0 and 1
		return position;
	}

	public Battleboat(int length) { //constructor
		int bound = getSize() - length; //sets furthest top-left coordinate a ship can start on
		int xorigin = randompos(bound); //sets origin coordinate
		int yorigin = randompos(bound);
		if (getOrientation() == true) { //figure out how to do this
			for (int i = 1; i < size; i++) { //loops 2 times for a 3-long ship
				//ship is vertical
			}
		} else {
			for (int i = 1; i < size; i++) { //loops 2 times for a 3-long ship
				//ship is horizontal
			}
		}
	}
}

