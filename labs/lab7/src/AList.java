import java.util.Arrays;
import java.util.ArrayList;

public class AList<T> {

	private T[] list;

	public AList(){
		list = (T[]) new Object[25];
	}

	public AList(int initialCapacity){
		T[] tempList = (T[]) new Object[initialCapacity];
		//cant figure out a way to get rid of this warning???
		list = tempList;
	}

	public boolean add(int newPosition, T element) { //this will insert an element at index newPosition in the list.
		list.add(newPosition, element);
		//what even is boolean about this

	}

	public T remove(int givenPosition) { //this will remove and return the element at index givenPosition.
		list.pop(givenPosition);
	}

	public static void main(String[] args) {
		AList<String> stringAList = new AList<String>(30);
		AList<Object[]> stringBList = new AList<Object[]>(30);
	}
}
