public class Board {
	private int column;
	private int row;
	private Boat[] boats;
	private Cell[][] board; //true board with all ships
	private Cell[][] knownboard; //board with unknown tiles, what will be seen during game
	private int numBoats;
	private Battleboats[] boats;
	private Cell[][] board;
	private int[] boatSizes;
	private double randompos;
//attributes = variables

	private int[] boatSizes() {
		int boatcount = numBoats();
		int[] boatsizes;
		if (boatcount == 1) {
			boatsizes = [2];
		} else if (boatcount == 3) {
			boatsizes = [2,3,4];
		} else if (boatcount == 5) {
			boatsizes = [2,3,3,4,5];
		} else {
			System.out.println("Something went wrong calculating the boat size array.");
			exit();
		}
		return boatsizes;
	}

	public void placeBoats() {
		for (int i = 0, i<numBoats(); i++) {
			for (int j = 0; i.boatcount.length; j++) {
				int xpos = randompos(x); // random gets rerolled every time the loop gets looped
				int ypos = randompos(y);
				//find some way to call orientation from Battleboats.java
			}
		}
	}
	// 1 = hit, 2 = miss, 3 = penalty
	public int fire(int x, int y) {
		//handles attacking a coordinate
		if (x <= 0 || x > row || y <= 0 || y > column) { //out of bounds
			System.out.println("Penalty.");
			return 3;
		} else if (knownboard[x-1][y-1].equals("B") || knownboard[x-1][y-1].equals("H")) || knownboard[x-1][y-1].equals("M")) { //repeat guess
			System.out.println("Penalty.");
			return 3;
		} else if (board[x-1][y-1].equals("B")) { //-1 accounts for 0 index
			System.out.println("Hit.");
			board[x-1][y-1] = "H";
			knownboard[x-1][y-1] = "H";
			// find some way to check if sunk
			return 1;
		} else {
			System.out.println("Miss.");
			board[x-1][y-1] = "M";
			knownboard[x-1][y-1] = "M";
			return 2;
		}
	}

	public void display() {
		System.out.println(knownboard);
	}

	public void print() {
		System.out.println(board);
	}

	public Board(int mode) {
		int x;
		int y;
		if (mode == 0) { //easy
			x = 3;
			y = 3;
			numBoats = 1;
			boatSizes = [2];
		} else if (mode == 1) { //intermediate
			x = 6;
			y = 6;
			numBoats = 3;
			boatSizes = [2,3,4];
		} else if (mode == 2) { //expert
			x = 9;
			y = 9;
			numBoats = 5;
			boatSizes = [2,3,3,4,5];
		} else {
			System.out.println("Something went wrong.");
			exit();
		}

		this.knownboard = new Cell[x][y];

		//constructs two blank 2d arrays
		for (int i=0; i<x; i++) {
			for (int j=0, j<y; j++) {
				knownboard[i][j] = new Cell(i,j,"-"); //creates a Cell object at every point in coordinates
			}
		}
		this.board = new Cell[x][y];
		for (int i = 0; i<x; i++) {
			for (int j = 0; j<y; j++) {
				board[i][j] = new Cell(i,j,"-"); //creates a Cell object at every point in coordinates
			}
		}
		//randompos generates a starting point for a boat
		randompos = Math.random() * n; //Math.random sets a random double between 0 and 1
	}
}
