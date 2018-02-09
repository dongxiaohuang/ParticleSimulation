package utils;

public class MinPriorityQueue<T extends Comparable<T>> {

    private static int CAPACITY = 1000;
    private static int ROOT_INDEX = 1
    
    private double[] tree;
    private int blank_index;
    
    public MinPriorityQueue() {
	this.tree = new double[CAPACITY];
	this.blank_index = ROOT_INDEX
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
	tree[blank_index] = elem;
	
	boolean finished = false;
	int parent_index = blank_index / 2;
	int child_index = blank_index;
	while (!finished) {
	    if (parent_index == 0)
		finished = true;
	    else {
		if (tree[parent_index].compareTo(elem) < 0) {
		    T temp = tree[child_index];
		    tree[child_index] = tree[parent_index];
		    tree[parent_index] = temp;

		    child_index = parent_index;
		    parent_index = parent_index / 2;
		}
		else
		    finished = true;
	    }
	}

	blank_index += 1;
    }

    /**
     * Removes, and returns, the element at the front of the queue.
     */
    public T remove() {
	if (blank_index <= ROOT_INDEX)
	    return null;

	T removed = tree[ROOT_INDEX);
	tree[ROOT_INDEX] = tree[blank_index-1];
	
	boolean finished = false;
	int parent_index = ROOT_INDEX;
	int child_index = 2 * parent_index;
	while (!finished) {
	    if (child_index >= blank_index)
		finished = true;
	    else {
		T max_child = tree[child_index];
		int c_neigh_index = child_index + 1;
		if (c_neigh_index<blank_index && max_child.compareTo(tree[c_neigh_index])<0) {
		    max_child = tree[c_neigh_index];
		    child_index = c_neigh_index;
		}

		if (max_child.compareTo(tree[parent_index]) > 0) {
		    tree[child_index] = tree[parent_index];
		    tree[parent_index] = max_child;
		    parent_index = child_index;
		    child_index = parent_index * 2;
		}
		else
		    finished = true;
	    }
	}
	    
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO implement this method
        return false;
    }
    
}
