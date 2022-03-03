public class Cell {
	private char status;
	private int row;
	private int col;

	public char getStatus() {
		return status;
	}
	public void setStatus(char c) {
		this.status = c;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public Cell(int row, int col, char status) { //constructor
		this.row = row;
		this.col = col;
		this.status = status;
	}
}
