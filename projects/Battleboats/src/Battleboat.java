public class Battleboat {
	private int size;
	private boolean orientation;
	private Cell[] spaces;
	private boolean sunk;

	public boolean getOrientation() {
		return orientation;
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

	public boolean checkSunk() {
		for (int i = 0; i<spaces.length; i++) {
			if (spaces[i].getStatus() != 'H') { //if any Cell is not hit
				return false;
			}
		}
		sunk = true;
		return true;
	}

	public boolean isSunk() {
		return sunk;
	}

	public Battleboat(int length) { //constructor
		sunk = false; //ship starts out not sunk
		size = length;

		double orient = Math.random(); //determines if boat is horizontal or vertical
		orientation = orient > 0.5; //true = vertical
	}
}

