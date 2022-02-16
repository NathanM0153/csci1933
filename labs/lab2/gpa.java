import java.util.Scanner;

public class gpa {
    public static void main(String[] args) {
        System.out.println("Enter grades:");
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        Scanner stringScanner = new Scanner(input);
        double weight = 0;
        String grade = "";
        double gpa_num = 0;
        double total_weight = 0;
        double total_gpa = 0;
        double avg_gpa = 0;
        String inputText = "";
        while(stringScanner.hasNext()) {
            inputText = stringScanner.next();
            grade = inputText;
            inputText = stringScanner.next();
            try { //while loop parses two inputs at a time, if things are out of order and weight is not a double, throws error
    			weight = Double.parseDouble(inputText);
			} catch (NumberFormatException nme) {
 				System.out.println("Error: Incorrect input format!");
   				System.exit(1);
			}
            gpa_num = gpa_helper(grade);
            total_gpa += gpa_num * weight;
            total_weight += weight;
        }
        avg_gpa = total_gpa / total_weight;
        System.out.println("The GPA is: " + avg_gpa);
    }  
    public static double gpa_helper(String input) {
        // double in class line to set return type
        double gpa = 0;
        if (input.toUpperCase().equals("A")) {
            gpa = 4.0;
        } else if (input.toUpperCase().equals("A-")) {
            gpa = 3.667;
        } else if (input.toUpperCase().equals("B+")) {
            gpa = 3.333;
        } else if (input.toUpperCase().equals("B")) {
            gpa = 3.0;
        } else if (input.toUpperCase().equals("B-")) {
            gpa = 2.667;
        } else if (input.toUpperCase().equals("C+")) {
            gpa = 2.333;
        } else if (input.toUpperCase().equals("C")) {
            gpa = 2.0;
        } else if (input.toUpperCase().equals("C-")) {
            gpa = 1.667;
        } else if (input.toUpperCase().equals("D+")) {
            gpa = 1.333;
        } else if (input.toUpperCase().equals("D")) {
            gpa = 1.0;
        } else if (input.toUpperCase().equals("F")) {
            gpa = 0.0;
        } else { //if things are in order but string is not a letter grade, throws this error
        	System.out.println("Error: Incorrect input format!");
        	System.exit(1);
        }    
        return gpa;
    }
}
