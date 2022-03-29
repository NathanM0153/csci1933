public class MatrixEntryTest {

	public static void main(String[] args) {
		MatrixEntry testObj = new MatrixEntry(12,12,12);
		System.out.println("Row: " + testObj.getRow() + "\nColumn: " + testObj.getColumn() + "\nValue: " + testObj.getData());

		testObj.setRow(20);
		testObj.setColumn(20);
		testObj.setData(20);
		System.out.println("Row: " + testObj.getRow() + "\nColumn: " + testObj.getColumn() + "\nValue: " + testObj.getData());

		testObj.setNextCol(testObj); //wrong, but don't otherwise understand how this can be MatrixEntry type
		testObj.setNextRow(testObj);
		System.out.println("Row: " + testObj.getNextRow() + "\nColumn: " + testObj.getNextCol() + "\nValue: " + testObj.getData());
	}
}