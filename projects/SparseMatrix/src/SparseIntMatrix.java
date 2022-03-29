public class SparseIntMatrix {
	private MatrixEntry matrix; //matrix being operated on
	private int numCols;
	private int numRows;

	public SparseIntMatrix(int numRows, int numCols) { //constructor
		this.numRows = numRows;
		this.numCols = numCols;
		// TODO: Input: integers with the number of rows and number of columns in this matrix,
		//  and a String with the filename of a file with matrix data.
		//  The format of the input file should be comma-delimited lines with the row, column, and data of each element.
		//  This constructor should populate the matrix with this data.
	}

	public SparseIntMatrix(int numRows, int numCols, String inputFile) { //constructor with file
		this.numRows = numRows;
		this.numCols = numCols;
		File inputFile = new File("matrix1_data.txt");
		//should populate matrix with file data
	}

	public int getElement(int row, int col) {
//		input: integers with the row and column of the desired element
//		output: corresponding element (integer) if one exists or zero otherwise.
		return 0;
		// TODO: Input: integers with the row and column of the desired element;
		//  Output: corresponding element (integer) if one exists or zero otherwise.
	}

	public boolean setElement(int row, int col, int data) {
//		input: integers with the row and column of the element to be set and an integer with the matrix data;
//		output: boolean indicating if operation was successful (i.e. row/col were in the correct range)
		return false;
		// TODO: Input: integers with the row and column of the element to be set and an integer with the matrix data;
		//  Output: boolean indicating if operation was successful (i.e. row/col were in the correct range)
	}

	public boolean removeElement(int row, int col, int data) {
//		input: integers with the row and column of the element to be removed;
//		output:  boolean indicating if an element was removed or not (false indicates that the element didn’t
//			previously exist or that the row/col were out of range, true indicates that it did and has been
//			removed). Any links to/from the element that was removed should be properly updated in the matrix.
		return false;
		// TODO: Input: integers with the row and column of the element to be removed;
		//  Output: boolean indicating if an element was removed or not
		//  (false indicates that the element didn’t previously exist or that the row/col were out of range,
		//  true indicates that it did and has been removed).
		//  Any links to/from the element that was removed should be properly updated in the matrix.
	}

	public int getNumCols() {
		return numCols;
	}

	public int getNumRows() {
		return numRows;
	}

	public boolean plus(SparseIntMatrix otherMat) {
		//input: another sparse matrix to be added.  This method should update the state of the current object.
		//output: boolean indicating if addition was successful (matrices should be identical dimensions)
		return false;
		// TODO: Input: another sparse matrix to be added to the current one.
		//  This method should update the state of the current object;
		//  Output: boolean indicating if addition was successful (matrices should be identical dimensions)
	}

	public boolean minus(SparseIntMatrix otherMat) {
		//input: another sparse matrix to be subtracted.  This method should update the state of the current object.
		//output: boolean indicating if subtraction was successful (matrices should be identical dimensions)
		return false;
		// TODO: Input: another sparse matrix to be subtracted from the current one.
		//  This method should update the state of the current object;
		//  Output: boolean indicating if addition was successful (matrices should be identical dimensions)
	}

}