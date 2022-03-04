import java.util.Scanner;

public class Game {
	public static boolean debug = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 0 for Easy difficulty, 1 for Intermediate, and 2 for Expert:");
		int gamemode = scanner.nextInt();
		System.out.println("Enable debug mode? Y/N");
		String enterdebug = scanner.next();
		if (enterdebug.equals("Y")) {
			debug = true;
		}
		//game starts
		Board gameboard = new Board(gamemode);
		int turns = 0;
		while (true) {
			if (debug) {
				gameboard.print();
			}
			gameboard.display();
			System.out.println("X coordinate of guess:");
			int guessx = scanner.nextInt();
			System.out.println("Y coordinate of guess:");
			int guessy = scanner.nextInt();
			turns++;
			gameboard.fire(guessx, guessy); //checks guess against board
			boolean isFinished = true;
			for (int i = 0; i<gameboard.getSize(); i++) {
				for (int j = 0; j<gameboard.getSize(); j++) { //getSize is the same because square board
					if (! gameboard.board[i][j].equals(gameboard.knownboard[i][j])) {
						isFinished = false;
					}
				}
			}
			if (isFinished) {
				System.out.println("Complete. Turns elapsed: " + turns);
				break;
			}
		}
	}
}
