public class SparseIntMatrixTest {
	public static void main(String[] args) {
		SparseIntMatrix matrix1 = new SparseIntMatrix(800,800,"matrix1_data.txt"); //800 is dimensions of thing
		MatrixViewer.show(matrix1); //this doesn't work yet but syntax should be right

		SparseIntMatrix matrix2 = new SparseIntMatrix(800,800,"matrix2_data.txt");
		MatrixViewer.show(matrix2);

		SparseIntMatrix matrix3 = new SparseIntMatrix(800,800,"matrix2_noise.txt");
		MatrixViewer.show(matrix3);
	}

}