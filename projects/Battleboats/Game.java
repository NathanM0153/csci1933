import java.util.Scanner;

public class Game {
	boolean debug = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter desired grid size (will format as square):");
		int size = scanner.nextInt();
		System.out.println("Enable debug mode? Y/N");
		String enterdebug = scanner.next();
		if (enterdebug.equals("Y")) {
			debug = true;
		}
	}
}
