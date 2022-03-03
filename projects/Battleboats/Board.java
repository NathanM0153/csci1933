public class Board {
	int column;
	int row;
	Boat[] boats;
	String[][] board; //true board with all ships
	String[][] knownboard; //board with unknown tiles, what will be seen during game

	private int numBoats() {
		if ((x == 3) && (y == 3)) {
			return 1;
		} else if ((x == 6) && (y == 6)) {
			return 3;
		} else if ((x == 9) && (y == 9)) {
			return 5;
		} else {
			System.out.println("Invalid board dimensions. Exiting program.");
			exit();
		}
	}

	//TODO: figure out how to do this
	private Battleboats[] boats() { //should contain all boats
		int[] boat2;
		int[] boat3_1;
		int[] boat3_2;
		int[] boat4;
		int[] boat5;
		//no idea what to do with these
	}

	private Cell[][] board() {
		//???
	}

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

	public void placeBoats(Boat[] boatcount, String[][] board), int x, int y) {
		for (int i=0; i.boatcount.length; i++) {
			int xpos = randompos(x); // random gets rerolled every time the loop gets looped
			int ypos = randompos(y);
			//find some way to call orientation from Battleboats.java
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

	public Board[int x, int y] { //constructs two blank 2d arrays
		this.knownboard = new String[x][y];
		for (int i=0; i<x; i++) {
			for (int j=0, j<y; j++) {
				knownboard[i][j] = "-";
			}
		}
		this.board = new String[x][y];
		for (int i = 0; i<x; i++) {
			for (int j = 0; j<y; j++) {
				board[i][j] = "-";
			}
		}
	}

}
