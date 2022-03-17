import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class AList<T> {

	private T[] list;
	private T element;
	private	String stringlist;
	private boolean check;

	public AList(){
		list = (T[]) new Object[25];
	}

	public AList(int initialCapacity){
		T[] tempList = (T[]) new Object[initialCapacity];
		//cant figure out a way to get rid of this warning???
		list = tempList;
	}

	public boolean add(int newPosition, T element) { //this will insert an element at index newPosition in the list
		if (newPosition >= list.length) {
			return false;
		} else {
			for (int i = list.length-2; i > newPosition; i--) { //working backwards
				list[i] = list[i + 1]; //shifts all elements right one
				if (i == (newPosition + 1)) {
					list[i] = element;
				}
			}
			return true;
		}
	}


	public T remove(int givenPosition) { //this will remove and return the element at index givenPosition.
		for (int i=0; i<list.length; i++) {
			if (i == givenPosition) {
				element = list[i];
				list[i] = list[i-1]; //shifts all elements left one
			} else if (i == (list.length-1)) { //delete last element
				list[i] = null;
			}
		}
		return element;
	}

	public boolean contains(T element) {

		for (int i = 0; i<list.length; i++) {
			if (list[i] != null) {
				check = true; //true if there is a non-null element
			}
		}
		return check;
	}

	public void add(Object[] list2) {
		Object[] newList = new Object[this.list.length+list2.length];
		for (int i = 0; i<list.length; i++) {
			newList[i] = list[i]; //+= is incorrect
		} for (int j = 0; j<list2.length; j++) {
			newList[j+list.length] = list[j];
		}
		this.list = (T[]) newList;
	}

	public String toString() {
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				stringlist += (String) list[i];
			}
		}
		return stringlist;
	}


	public static void main(String[] args) {
		AList<String> stringAList = new AList<String>(30);
		AList<Object[]> stringBList = new AList<Object[]>(30);
		stringAList.add(2,"test");
		stringBList.remove(5);
		stringAList.contains("test");
		stringAList.add(stringAList.list);
		System.out.println(stringAList.toString());
	}
}
