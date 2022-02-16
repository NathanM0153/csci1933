public class Application {
	public static void main(String[] args) {
		// System.out.println("Hello world!");
		int current_year = 2022;
		int birth_year = 2001;
		System.out.println((current_year - birth_year) * 365);
		
		int numerator = 3;
		int denominator = 4;
		int quotient = numerator / denominator;
		System.out.println(quotient);
		
		float flnumerator = 3;
		float fldenominator = 4;
		float floatquot = flnumerator / fldenominator;
		System.out.println(floatquot);
		
		String firstname = "Nathan";
		String lastname = "Michel";
		System.out.println("My first name is - " + firstname);
		System.out.println("My last name is - " + lastname);
		System.out.println("My full name is - " + firstname + " " + lastname);
			
		BankAccount myAccount = new BankAccount("Java", "CSCI1933 rules!", 100.50);
			System.out.println("My account's balance is: " + myAccount.getBalance("CSCI1933 rules!"));
		BankAccount myOtherAccount = new BankAccount("Java", "Python is better.", 3.5);
			System.out.println("My other account's balance is: " + myOtherAccount.getBalance("Python is better."));
			

}
}

