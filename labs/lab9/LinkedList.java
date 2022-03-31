import java.util.*;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> first, last;
    private int size;

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
        Scanner s;

        private LinkedListIterator() {

        }

        @Override
        public boolean hasNext() {
            s = new Scanner();
            return s.hasNext();
        }

        @Override
        public T next() {
            //what is this supposed to do? sample returns null but??
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    // TODO implement me!
    public static int[] nCopies(LinkedList<Integer> x) {
        int[] arr = new int[x.size];
        for (int i=0; i<x.size; i++) { //for each element in LL
            for (Integer j=0; j<x; j++) { //loops x times
                arr += (int[]) x;
            }
        }
    }

    // TODO implement me!
    public static LinkedList<Integer> countingSort(LinkedList<Integer> lst) {
        int k = 0; //maximum element of lst
        int[] counts = new int[k+1];
        for (int i=0; i<lst.size; i++) {

        }
    }

    // TODO implement me!
    public void reverse() {
    
    }

    // TODO implement me!
    public void shuffle() {

    }

    // TODO implement me!
    public static void main(String[] args) {

    }

}
