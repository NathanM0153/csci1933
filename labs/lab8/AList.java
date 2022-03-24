import java.util.*;
import java.io.File;

/**
 * A class that implements a list of objects by using an array.
 * Entries in a list have positions that begin with 1.
 * Duplicate entries are allowed.
 *
 * Modified from Frank M. Carrano's
 * Data Structures and Abstractions with Java (3rd Edition)
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */

public class AList<T extends Comparable> {
	private T[] list;   // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public AList() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public AList(int initialCapacity) {
		integrityOK = false;

		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else // Is initialCapacity too big?
			checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Comparable[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		integrityOK = true;
	} // end constructor

	public void add(T newEntry) {
		add(numberOfEntries + 1, newEntry);
/*    // Alternate code
		checkIntegrity();
      list[numberOfEntries + 1] = newEntry;
      numberOfEntries++;
      ensureCapacity();
*/
	} // end add

	public void add(int givenPosition, T newEntry) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
			if (givenPosition <= numberOfEntries)
				makeRoom(givenPosition);
			list[givenPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity(); // Ensure enough room for next add
		} else
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
	} // end add

	public void add(T[] addList) {
		if (addList.length == 0)
			return;
		for (int i = 0; i < addList.length; i++) {
			add(addList[i]);
		}
	} // end add

	public T remove(int givenPosition) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty
			T result = list[givenPosition]; // Get entry to be removed

			// Move subsequent entries towards entry to be removed,
			// unless it is last in list
			if (givenPosition < numberOfEntries)
				removeGap(givenPosition);
			list[numberOfEntries] = null;
			numberOfEntries--;
			return result;                  // Return reference to removed entry
		} else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	} // end remove

	public void clear() {
		checkIntegrity();

		// Clear entries but retain array; no need to create a new array
		for (int index = 1; index <= numberOfEntries; index++) // Loop is part of Q4
			list[index] = null;

		numberOfEntries = 0;
	} // end clear

	public T replace(int givenPosition, T newEntry) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty
			T originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	} // end replace

	public T getEntry(int givenPosition) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty
			return list[givenPosition];
		} else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	} // end getEntry

	public T[] toArray() {
		checkIntegrity();

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries]; // Unchecked cast
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index + 1];
		} // end for

		return result;
	} // end toArray

	public boolean contains(T anEntry) {
		checkIntegrity();
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries)) {
			if (anEntry.equals(list[index]))
				found = true;
			index++;
		} // end while
		return found;
	} // end contains

	public int getLength() {
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty() {
		return numberOfEntries == 0; // Or getLength() == 0
	} // end isEmpty

	// Doubles the capacity of the array list if it is full.
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity() {
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity); // Is capacity too big?
			list = Arrays.copyOf(list, newCapacity + 1);
		} // end if
	} // end ensureCapacity

	// Makes room for a new entry at newPosition.
	// Precondition: 1 <= newPosition <= numberOfEntries + 1;
	//               numberOfEntries is list's length before addition;
	//               checkIntegrity has been called.
	private void makeRoom(int givenPosition) {
		// Assertion: (newPosition >= 1) && (newPosition <= numberOfEntries + 1)
		int newIndex = givenPosition;
		int lastIndex = numberOfEntries;

		// Move each entry to next higher index, starting at end of
		// list and continuing until the entry at newIndex is moved
		for (int index = lastIndex; index >= newIndex; index--)
			list[index + 1] = list[index];
	}  // end makeRoom

	// Shifts entries that are beyond the entry to be removed to the
	// next lower position.
	// Precondition: 1 <= givenPosition < numberOfEntries;
	//               numberOfEntries is list's length before removal;
	//               checkIntegrity has been called.
	private void removeGap(int givenPosition) {
		int removedIndex = givenPosition;
		for (int index = removedIndex; index < numberOfEntries; index++)
			list[index] = list[index + 1];
	} // end removeGap

	// Throws an exception if this object is corrupt.
	private void checkIntegrity() {
		if (!integrityOK)
			throw new SecurityException("AList object is corrupt.");
	} // end checkIntegrity

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a list " +
					"whose capacity exceeds " +
					"allowed maximum.");
	} // end checkCapacity

	// Creates a string representation of the list.
	public String toString() {
		String toReturn = "[";
		for (int i = 1; i < numberOfEntries; i++) {
			toReturn += list[i].toString() + ", ";
		}
		toReturn += list[numberOfEntries].toString() + "]";

		return toReturn;
	} // end toString



	public AList<T> slice(int start, int stop) {
		AList slicedList = new AList(stop - start); //create empty list
		int count = 0;
		for (int i = start; i < stop; i++) {
			slicedList.add(list[i]);
		}
		return slicedList;
	}

	public AList<T> slice(int start, int stop, int step) {
		AList slicedList = new AList(stop - start); //create empty list
		int count = 0;
		for (int i = start; i < stop; i += step) {
			slicedList.add(list[i]);
		}
		return slicedList;
	}

	public void merge(T[] array, int left, int mid, int right) {
		int leftLen = mid - left - 1;
		int rightLen = right - mid;
//		int[] leftArr = new int[leftLen];
		T[] leftArr = (T[]) new Object[leftLen];
//		int[] rightArr = new int[rightLen];
		T[] rightArr = (T[]) new Object[rightLen];
		int leftIndex = 1;
		int rightIndex = 1;
		for (int i = 1; i < leftLen; i++) {
			leftArr[i] = (T) array[left + i];
		}
		for (int i = 1; i < rightLen; i++) {
			rightArr[i] = (T) array[left + i];
		}
		for (int i = left; i < right + 1; i++) {
			if (leftIndex < leftLen && rightIndex < rightLen) {
				if ((int) leftArr[leftIndex] < (int) rightArr[rightIndex]) {
					array[i] = leftArr[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArr[rightIndex];
					rightIndex++;
				}
			}
		}
	}

	public void mergeRev(T[] array, int left, int mid, int right) {
		int leftLen = mid - left - 1;
		int rightLen = right - mid;
		T[] leftArr = (T[]) new Object[leftLen];
		T[] rightArr = (T[]) new Object[rightLen];
		int leftIndex = 1;
		int rightIndex = 1;
		for (int i = 1; i < leftLen; i++) {
			leftArr[i] = (T) array[left + i];
		}
		for (int i = 1; i < rightLen; i++) {
			rightArr[i] = (T) array[left + i];
		}
		for (int i = left; i < right + 1; i++) {
			if (leftIndex < leftLen && rightIndex < rightLen) {
				if ((int) leftArr[leftIndex] > (int) rightArr[rightIndex]) {
					array[i] = leftArr[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArr[rightIndex];
					rightIndex++;
				}
			}
		}
	}

	public void mergeSortRev(T[] array, int left, int right) {
		if (right > left) {
			return; //return type is void
		}
		int mid = (left + right) / 2;
		mergeSortRev(array, left, mid);
		mergeSortRev(array, mid + 1, right);
		mergeRev(array, left, mid, right);
	}

	public void mergeSort(T[] array, int left, int right) {
		if (right <= left) {
			return; //return type is void
		}
		int mid = (left + right) / 2;
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);
		merge(array, left, mid, right);
	}

	public void sort(boolean ascending) {
		if (! ascending) {
			mergeSortRev(list, 1, list.length); //how to insert testList here?
			//reverse list
		} else {
			mergeSort(list, 1, list.length);
		}
	}

	// Converts a given file into a list.
	public static AList<String> fileToAList(File input) {
		Scanner s;
		List<String> inputList = new ArrayList<>();
		try {
			s = new Scanner(input);
		} catch (Exception e) {
			System.out.println("File not found");
			return null;
		}
		for (int i = 0; i<input.length(); i++) { //iterates through each line
			inputList += s.nextLine();
		}
		return null;
	}

	public static void main(String[] args) {
		int capacity = 25;
		AList testList = new AList(capacity);
		for (int i = 0; i<capacity; i++) { //creates list of numbers 1 to capacity
			testList.add(i+1);
		}
//		System.out.println(testList.slice(8,15));
//		System.out.println(testList.slice(4,20,2));
		testList.sort(true);
		System.out.println(testList);
		testList.sort(false);
		System.out.println(testList);
	}
}