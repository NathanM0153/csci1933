public class Matrix Entry {
	private int row;
	private int col;

	public MatrixEntry(int row, int col, int data) {

	}

	public int getColumn() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public void setColumn(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getData() { //input: none; output: an integer corresponding to the data associated with this entry

	}

	public MatrixEntry getNextRow() { //a MatrixEntry reference for this entry’s next row.

	}

	public void setNextRow(MatrixEntry el) { //MatrixEntry reference of this entry’s next row

	}

	public MatrixEntry getNextCol() { //a MatrixEntry reference for this entry’s next column

	}

	public void setNextCol() { //MatrixEntry reference of this entry’s next column

	}
}