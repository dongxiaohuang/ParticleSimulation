package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MinPriorityQueue<T extends Comparable<T>> {

    private static int CAPACITY = 1000;
    private static int ROOT_INDEX = 1;

    private List<T> tree;
    private int blank_index;

    public MinPriorityQueue() {
	this.tree = new ArrayList<T>(50);
	this.tree.add(0, null);
	this.blank_index = ROOT_INDEX;
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
	return tree.size() - 1;
    }

    /**
     * Adds elem to the queue.
     */
    public void add(T elem) {
	tree.add(blank_index, elem);

	boolean finished = false;
	int parent_index = blank_index / 2;
	int child_index = blank_index;
	while (!finished) {
	    if (parent_index == 0)
		finished = true;
	    else {
		if (tree.get(parent_index).compareTo(elem) < 0) {
		    Collections.swap(tree, child_index, parent_index);

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

	T removed = tree.get(ROOT_INDEX);
	tree.set(ROOT_INDEX, tree.get(blank_index-1));
	tree.remove(blank_index-1);
	blank_index -= 1;

	boolean finished = false;
	int parent_index = ROOT_INDEX;
	int child_index = 2 * parent_index;
	while (!finished) {
	    if (child_index >= blank_index)
		finished = true;
	    else {
		T max_child = tree.get(child_index);
		int c_neigh_index = child_index + 1;
		if (c_neigh_index<blank_index && max_child.compareTo(tree.get(c_neigh_index))<0) {
		    max_child = tree.get(c_neigh_index);
		    child_index = c_neigh_index;
		}

		if (max_child.compareTo(tree.get(parent_index)) > 0) {
		    Collections.swap(tree, child_index, parent_index);
		    parent_index = child_index;
		    child_index = parent_index * 2;
		}
		else
		    finished = true;
	    }
	}
	return removed;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
	return this.size() == 0;
    }

}
