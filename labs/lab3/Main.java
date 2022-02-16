import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(iterativeReverse(44318));
        System.out.println(recursiveReverse(44318));
        System.out.println("Enter desired Fibonacci index:");
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        int i = Integer.parseInt(input); // https://www.javatpoint.com/java-string-to-int
        System.out.println("Fibonacci value: " + fibonacciRecursive(i));
        // write your code here
    }

    public static int iterativeReverse(int num) {
        int count = 0;
        String numString = (String.valueOf(num));
        int length = numString.length();
        int reverse = 0;
        int newplace = 0;
        while (count < length) {
            newplace = num % 10;
            num /= 10;
            reverse *= 10;
            reverse += newplace;
            count++;
        }
        return reverse;
    }
static int reverse;
    public static int recursiveReverse (int num) {
        int newplace;
        String numString = (String.valueOf(num));
        int length = numString.length();
        if (num < 10) {
            newplace = num % 10;
            num = num / 10;
            reverse *= 10;
            reverse += newplace;
            return reverse;
        } else {
            newplace = num % 10;
            num = num / 10;
            reverse *= 10;
            reverse += newplace;
            recursiveReverse(num);
        }
        return reverse;
    }

    public static int fibonacciRecursive(int n) {
        if ((n == 0) || (n == 1)) { // "||" operand is the or function
            return n;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }
}
