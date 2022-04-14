//Selection, Bubble, Insertion Sort - O(n^2)
//Merge Sort - n*log(n)
//Quick Sort - average: n*log(n) to worst: n^2


private class Node {
	private T data;
	private Node next;
	private Node(T dataPortion) { //constructor
		data = dataPortion;
		next = null;
	}
	private Node(T dataPortion, Node nextNode) {
		data = dataPortion;
		next = nextNode;
	}
}


System.arraycopy(Object sourceArray, source position start, tempArray, destination position, length)
