public class Rational {
	int numerator;
	int denominator;
	double rationalnum = 1.0;

    public Rational(int numerator, int denominator) {
    	this.numerator = numerator;
		this.denominator = denominator;
}

    public static void main(String[] args) {
    	// Rationalnum = numerator / denominator;
    	// System.out.println(boolean sum = addRational(3,2) == 5);
    	// System.out.println(boolean diff =subRational(3,2) == 1);
    	// System.out.println(boolean product = mulRational(3,2) == 6);
    	// System.out.println(boolean quotient = divRational(3,2) == (1.5));
    	Rational r1 = Rational(1,2);
    	Rational r2 = Rational(2,3);
    	System.out.println(r1.addRational(r2));


    }
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public void addRational(Rational r) {
		this.numerator = (this.getNumerator() * r.getDenominator()) + (this.getNumerator() * r.getDenominator());
		this.denominator = this.getDenominator() * r.getDenominator();
	}
	public void subRational(Rational r) {
		this.numerator = (this.getNumerator() * r.getDenominator()) - (this.getNumerator() * r.getDenominator());
		this.denominator = this.getDenominator() * r.getDenominator();
	}
	public void mulRational(Rational r) {
		this.numerator = this.getNumerator() * r.getNumerator();
		this.denominator = this.getDenominator() * r.getDenominator();
	}
	public void divRational(Rational r) {
		this.numerator = this.getNumerator() * r.getDenominator();
		this.denominator = this.getDenominator() * r.getNumerator();
	}
}
