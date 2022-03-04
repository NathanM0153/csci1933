public class Board {
	private int size;
	public Cell[][] board; //true board with all ships
	public Cell[][] knownboard; //board with unknown tiles, what will be seen during game
	private int numBoats;
	private Battleboat[] boats;
	private int[] boatSizes;

	public void placeBoats() {
		int xorigin;
		int yorigin;
		boats = new Battleboat[numBoats]; //parameter sets length of array, not anything in the class
		for (int i = 0; i<numBoats; i++) { //loops # of times as there are boats
			boats[i] = new Battleboat(boatSizes[i]); //BB constructor, initializing value
			Cell[] spaces = new Cell[boatSizes[i]]; //initializing array, square braces
			//randompos generates a starting point for a boat
			double randompos = Math.random() * size; //Math.random sets a random double between 0 and 1
			int bound = size - boats[i].getSize(); //sets furthest top-left coordinate a ship can start on
			if (boats[i].getOrientation()) { //vertical
				xorigin = (int) (Math.random() * size);//only one dimension needs limited
				yorigin = (int) (Math.random() * bound);
				for (int j = 0; j < boats[i].getSize(); j++) {
					board[xorigin][yorigin + j].setStatus('B'); //j starts at 0
					spaces[j] = board[xorigin][yorigin + j];
				}
			} else { //horizontal
				xorigin = (int) (Math.random() * bound);
				yorigin = (int) (Math.random() * size);
				for (int j = 0; j < boats[i].getSize(); j++) {
					board[xorigin + j][yorigin].setStatus('B'); //j starts at 0
					spaces[j] = board[xorigin + j][yorigin];
				}
			}
			boats[i].setSpaces(spaces); //sets boat array to same pointers as location on grid
		}
	}

	// 1 = hit, 2 = miss, 3 = penalty
	public int fire(int x, int y) {
		//handles attacking a coordinate
		if (x <= 0 || x > getSize() || y <= 0 || y > getSize()) { //out of bounds
			System.out.println("Penalty. Out of bounds.");
			return 3;
		} else if (knownboard[x-1][y-1].getStatus() == 'B' || knownboard[x-1][y-1].getStatus() == 'H' || knownboard[x-1][y-1].getStatus() == 'M') { //repeat guess
			System.out.println("Penalty. Repeat guess.");
			return 3;
		} else if (board[x-1][y-1].getStatus() == ('B')) { //-1 accounts for 0 index
			System.out.println("Hit.");
			board[x-1][y-1].setStatus('H');
			knownboard[x-1][y-1].setStatus('H');
			if (checkSunk()) {
				System.out.println("Sunk.");
			}
			return 1;
		} else {
			System.out.println("Miss.");
			board[x-1][y-1].setStatus('M');
			knownboard[x-1][y-1].setStatus('M');
			return 2;
		}
	}



	public void display() { //toString() doesn't work with arrays
		String stringarray = "";
		for (int i = 0; i < size; i++) { // sets array to grid of strings
			for (int j = 0; j < size; j++) {
				stringarray += knownboard[j][i].getStatus() + " ";
			}
			stringarray += "\n";
		}
		System.out.println(stringarray);
	}

	public void print() {
		String stringarray = "";
		for (int i = 0; i < size; i++) { // sets array to grid of strings
			for (int j = 0; j < size; j++) {
				stringarray += board[j][i].getStatus() + " ";
			}
			stringarray += "\n";
		}
		System.out.println(stringarray);
	}

	public int getSize() {
		return size;
	} // only need one getter because board is square

	public boolean checkSunk() {
		boolean ifsunk = false;
		for (Battleboat boat : boats) {
			if (! boat.isSunk()) { //if boat is not sunk
				if (boat.checkSunk()) {
					ifsunk = true;
				}
			}
		}
		return ifsunk; //boats can overlap with this code, checks every ship to see if you sunk multiple ships
	}

	public Board(int mode) {
		if (mode == 0) { //easy
			size = 3;
			numBoats = 1;
			boatSizes = new int[]{2};
		} else if (mode == 1) { //intermediate
			size = 6;
			numBoats = 3;
			boatSizes = new int[]{2,3,4};
		} else if (mode == 2) { //expert
			size = 9;
			numBoats = 5;
			boatSizes = new int[]{2,3,3,4,5};
		} else {
			System.out.println("Something went wrong constructing the board.");
			System.exit(1);
		}

		this.knownboard = new Cell[size][size];

		//constructs two blank 2d arrays
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				knownboard[i][j] = new Cell(i,j, '-'); //creates a Cell object at every point in coordinates
			}
		}
		this.board = new Cell[size][size];
		for (int i = 0; i<size; i++) {
			for (int j = 0; j<size; j++) {
				board[i][j] = new Cell(i,j, '-'); //creates a Cell object at every point in coordinates
			}
		}
		placeBoats();
	}
}
