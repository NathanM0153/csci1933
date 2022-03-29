public class MatrixEntry<T> { // implements ListInterface<T>
	private int row;
	private int col;
	private int data; //value of cell
	private MatrixEntry nextRow;
	private MatrixEntry nextCol;

	public MatrixEntry(int row, int col, int data) { //constructor
		this.row = row;
		this.col = col;
		this.data = data;
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
		return data;
	}

	public void setData(int data)  {
		this.data = data;
	}

	public MatrixEntry getNextRow() { //a MatrixEntry reference for this entry’s next row.
		return nextRow;
	}

	public void setNextRow(MatrixEntry el) { //MatrixEntry reference of this entry’s next row
		this.nextRow = el;
	}

	public MatrixEntry getNextCol() { //a MatrixEntry reference for this entry’s next column
		return nextCol;
	}

	public void setNextCol(MatrixEntry el) { //MatrixEntry reference of this entry’s next column
		this.nextCol = el;
	}
}