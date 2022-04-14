import java.util.HashMap;
import java.util.Scanner;
import java.lang.Character;
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
		for (int i=0; i<2; i++) { //for each word (2 names)
			str = s.next();
			for (int j=0; j<str.length();j++) { //for each letter in word
				charr.add(str.charAt(j));
			}
		} //charr is now an array of all characters in the name
	}

	public char[] charMap(char[] charr) {
		int[] arr = new int[26];

		for (int i : charr) {
			if (charr[i].isUpperCase) {
				charr[i].toLowerCase;
			}
			if (charr[i] == 'a') {

			}
		}

	}



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

	}
}
