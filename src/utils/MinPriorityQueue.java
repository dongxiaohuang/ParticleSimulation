package utils;

public class MinPriorityQueue<T extends Comparable<T>> {

    private static int CAPACITY = 1000;
    
    private double[] tree;
    private int index;
    
    public MinPriorityQueue() {
	tree = new double[CAPACITY];
	index = 1
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
        // TODO implement this method
        return 0;
    }
    
    /**
     * Adds elem to the queue.
     */
    public void add(T elem) {
        // TODO implement this method
	tree[index] = elem;
	boolean finished = true;
    }

    /**
     * Removes, and returns, the element at the front of the queue.
     */
    public T remove() {
        // TODO implement this method
        return null;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO implement this method
        return false;
    }
    
}
