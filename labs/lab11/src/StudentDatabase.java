import java.util.HashMap;
import java.util.Scanner;
import java.lang.Character;

import static java.lang.System.exit;

public class StudentDatabase {
	private HashMap<Integer, Student> dict;

	public StudentDatabase() {
		dict = new HashMap<>();
	}

	public boolean addStudent(int studentID, Student student) {
		if (dict.containsKey(studentID)) {
			return false;
		} else {
			dict.put(studentID, student);
			return true;
		}
	}
	public String getStudentName(int studentID) {
		if (dict.containsKey(studentID)) {
			return dict.get(studentID).getFirstName() + " " + dict.get(studentID).getLastName();
		} else {
			return null;
		}
	}

	public boolean removeStudent(int studentID) {
		if (dict.containsKey(studentID)) {
			dict.remove(studentID);
			return true;
		} else {
			return false;
		}
	}
	public String toString() {
		String string = "";
		for (Integer key : dict.keySet()) {
			string += (key.toString() + ": " + dict.get(key)) + "\n";
		}
		return string;
	}

	public HashMap<Character, Integer> getLetterFrequency(int studentID) {
		HashMap map = new HashMap<>();
		String name = getStudentName(studentID);
		Scanner s = new Scanner(name);
		String str = "";
		char[] charr = new char[50]; //haha funny
		int[] arr = new int[26];
		for (int i : arr) { //sets array to all 0's
			arr[i] = 0;
		}
		for (int i=0; i<2; i++) { //for each word (2 names)
			str = s.next();
			for (int j=0; j<str.length();j++) { //for each letter in word
				charr.add(str.charAt(j));
			}
		} //charr is now an array of all characters in the name
		letterFinder(charr, arr);
		//TODO:how to add arrays to map var?
	}

	public void letterFinder(char[] charr, int[] arr) {
		for (char i : charr) {
			if (charr[i] == 'a' || charr[i] == 'A') { //increments index if is that letter
				arr[0] += 1;
			} else if (charr[i] == 'b' || charr[i] == 'B') {
				arr[1] += 1;
			} else if (charr[i] == 'c' || charr[i] == 'C') {
				arr[2] += 1;
			} else if (charr[i] == 'd' || charr[i] == 'D') {
				arr[3] += 1;
			} else if (charr[i] == 'e' || charr[i] == 'E') {
				arr[4] += 1;
			} else if (charr[i] == 'f' || charr[i] == 'F') {
				arr[5] += 1;
			} else if (charr[i] == 'g' || charr[i] == 'G') {
				arr[6] += 1;
			} else if (charr[i] == 'h' || charr[i] == 'H') {
				arr[7] += 1;
			} else if (charr[i] == 'i' || charr[i] == 'I') {
				arr[8] += 1;
			} else if (charr[i] == 'j' || charr[i] == 'J') {
				arr[9] += 1;
			} else if (charr[i] == 'k' || charr[i] == 'K') {
				arr[10] += 1;
			} else if (charr[i] == 'l' || charr[i] == 'L') {
				arr[11] += 1;
			} else if (charr[i] == 'm' || charr[i] == 'M') {
				arr[12] += 1;
			} else if (charr[i] == 'n' || charr[i] == 'N') {
				arr[13] += 1;
			} else if (charr[i] == 'o' || charr[i] == 'O') {
				arr[14] += 1;
			} else if (charr[i] == 'p' || charr[i] == 'P') {
				arr[15] += 1;
			} else if (charr[i] == 'q' || charr[i] == 'Q') {
				arr[16] += 1;
			} else if (charr[i] == 'r' || charr[i] == 'R') {
				arr[17] += 1;
			} else if (charr[i] == 's' || charr[i] == 'S') {
				arr[18] += 1;
			} else if (charr[i] == 't' || charr[i] == 'T') {
				arr[19] += 1;
			} else if (charr[i] == 'u' || charr[i] == 'U') {
				arr[20] += 1;
			} else if (charr[i] == 'v' || charr[i] == 'V') {
				arr[21] += 1;
			} else if (charr[i] == 'w' || charr[i] == 'W') {
				arr[22] += 1;
			} else if (charr[i] == 'x' || charr[i] == 'X') {
				arr[23] += 1;
			} else if (charr[i] == 'y' || charr[i] == 'Y') {
				arr[24] += 1;
			} else if (charr[i] == 'z' || charr[i] == 'Z') {
				arr[25] += 1;
			} else {
				System.out.println("Invalid input.");
				exit(1);
			}
		}
	}
	//overly verbose method that adds 1 to respective index in arr (which is currently all 0's) for each letter in charr


	public static void main(String[] args) {
		StudentDatabase test = new StudentDatabase();
		Student studentTest = new Student("Nathan", "Michel");
		Student student2 = new Student("Test", "Java");
		int ID = 1;
		test.addStudent(2,student2);
		System.out.println(test.addStudent(ID, studentTest)); //true
		System.out.println(test.getStudentName(ID)); 		  //name
		System.out.print(test);								  //list of names
		System.out.println(test.removeStudent(ID));			  //true
		//System.out.println(test.getLetterFrequency(ID));

	}
}
