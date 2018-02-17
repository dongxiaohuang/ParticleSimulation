package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MinPriorityQueue<T extends Comparable<T>> {
    // the index of root
    private static int ROOT_INDEX = 1;
    private static int INITIAL_CAPACITY = 50;

    // dynamic list representing the tree structure
    private List<T> tree;
    // the index of place in the list for next insertion
    private int blank_index;

    public MinPriorityQueue() {
	this.tree = new ArrayList<T>(INITIAL_CAPACITY);
	// "null" as placeholder of index 0
	this.tree.add(0, null);
	this.blank_index = ROOT_INDEX;
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
	// subtract the items before the ROOT_INDEX
	return tree.size() - ROOT_INDEX;
    }

    /**
     * Adds elem to the queue.
     */
    public void add(T elem) {
	tree.add(blank_index, elem);

	boolean finished = false;
	int child_index = blank_index;
	int parent_index = child_index / 2;
	while (!finished) {
	    if (parent_index < ROOT_INDEX)
		// finish if no parent available
		finished = true;
	    else {
		if (tree.get(parent_index).compareTo(elem) > 0) {
		    // swap the items if the parent node is greater than the child one
		    Collections.swap(tree, child_index, parent_index);

		    child_index = parent_index;
		    parent_index = child_index / 2;
		}
		else
		    finished = true;
	    }
	}
	// update the index for next insertion
	blank_index += 1;
    }

    /**
     * Removes, and returns, the element at the front of the queue.
     */
    public T remove() {
	if (this.isEmpty())
	    // return null if no content inside
	    return null;

	// remove the item at the root and move the last item to the root
	T removed = tree.get(ROOT_INDEX);
	tree.set(ROOT_INDEX, tree.get(blank_index-1));
	tree.remove(blank_index-1);
	blank_index -= 1;

	boolean finished = false;
	int parent_index = ROOT_INDEX;
	int child_index = 2 * parent_index;
	while (!finished) {
	    if (child_index >= blank_index)
		// finish if no more child node item available
		finished = true;
	    else {
		T min_child = tree.get(child_index);
		int c_neigh_index = child_index + 1;
		if (c_neigh_index<blank_index && min_child.compareTo(tree.get(c_neigh_index))>0) {
		    // set the item next to the child one as minimum child and update the child index
		    min_child = tree.get(c_neigh_index);
		    child_index = c_neigh_index;
		}

		if (min_child.compareTo(tree.get(parent_index)) < 0) {
		    // swap the items of parent node and child node if minimum child is less than its parent node
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
