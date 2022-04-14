import java.util.*;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
	private Node<T> first, last;
	private int size;
	private Node node;

	public LinkedList() {
		first = null;
		last = null;
		size = 0;
	}

	public boolean add(T element) {
		// for the sake of lab, let's _not_ allow null data
		if(element == null) return false;

		Node<T> newNode = new Node<>(element);

		if(size == 0)
			first = newNode;
		else
			last.setNext(newNode);

		last = newNode;
		size++;

		return true;
	}

	public String toString() {
		String ret = "[";
		Node<T> ptr = first;
		for(int i = 0; i < size; i++) {
			ret += ptr.getData().toString() + ", ";
			ptr = ptr.getNext();
		}

		return size == 0 ? ret + "]" : ret.substring(0, ret.length() - 2) + "]";
	}

	// TODO implement me!
	private class LinkedListIterator implements Iterator<T> {
		Node<T> node1;
		private LinkedListIterator() {
			node1 = first;
		}

		@Override
		public boolean hasNext() {
			return node1.getNext() != null; //false if null
		}

		@Override
		public T next() {
			if (hasNext() || node1 == last) {
				T temp = node1.getData();
				node1 = node1.getNext();
				return temp;
			} else {
				return null;
			}
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	// TODO implement me!
	public static int[] nCopies(LinkedList<Integer> x) {
		int sum = 0;
		for (int i : x) {
			sum += i; //sums up linked list
		}
		sum += x.last.getData();
		int count = 0;
		int[] arr = new int[sum];
		for (int i : x) { //for each element in LL
			for (int j=0; j<i; j++) { //loops x times
				arr[count] += i;
				count++;
			}
		}
		for (int j=0; j<x.last.getData(); j++) { //loops x times
			arr[count] += x.last.getData();
			count++;
		}
		return arr;
	}

	// TODO implement me!
	public static LinkedList<Integer> countingSort(LinkedList<Integer> lst) {
		int k = Integer.MIN_VALUE;
		for (int i : lst) {
			if (i > k) {
				k = i; //set new maximum if i > k
			}
		}
		int[] counts = new int[k+1];
		for (int i : lst) {
			counts[i] += 1;
		}
		LinkedList<Integer> ret = new LinkedList<Integer>();
		for (int i=0; i<k+1; i++) {
			for (int j=0; j<counts[i] ;j++) {
				ret.add(i);
			}
		}
		return ret;
	}

	// TODO implement me!
	public void reverse() {
		this.node = node;
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.getNext(); //shuffling to reverse
			current.setNext(prev); //https://www.geeksforgeeks.org/reverse-a-linked-list/
			prev = current; //shifting all elements forward one
			current = next;
		}
		node = prev;
	}

	// TODO implement me!
	public void shuffle() {
		//lol no
	}

	// TODO implement me!
	public static void main(String[] args) {
		LinkedList<Integer> testList = new LinkedList<Integer>();
		testList.add(7);
		testList.add(6);
		testList.add(4);
		int[] arr = nCopies(testList);
		for (int i : arr) {
			System.out.println(i);
		}

		System.out.println(countingSort(testList));
		System.out.println(testList);
		testList.reverse();
		System.out.println(testList);
	}

}
