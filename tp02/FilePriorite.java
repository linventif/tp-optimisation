package tp02;
import java.util.Comparator;

/**
 * Interface for a priority queue
 * @author from JAVA API
 * @date January 18th
 */

public interface FilePriorite<E> {
    /** Removes all of the elements from this priority queue. */
    void clear();
	
    /**Returns the comparator used to order the elements in this queue, or null if this queue is sorted according to the natural ordering of its elements. */
    Comparator<? super E> comparator();

    /** Inserts the specified element into this priority queue. */
    boolean 	offer(E e);

    /** Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty. */
    E 	peek();

    /** Retrieves and removes the head of this queue, or returns null if this queue is empty. */
    E 	poll();

    /** Returns the number of elements in this collection. */
    int 	size();

    /** Returns <code>true</code> if this collection contains no elements. */
    boolean isEmpty();
}

