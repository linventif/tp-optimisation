package tp02;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;

public class FilePrioriteTas<E> implements FilePriorite<E> {
  private E[] tas;
  private int size = 0;
  private int defaultSize = 10;

  public static void main(String[] args) {
    FilePrioriteTas<Integer> nTas = new FilePrioriteTas<>();
    System.out.println(nTas.size());
    System.out.println(nTas.isEmpty());
    System.out.println(nTas);
    nTas.offer(14);
    System.out.println(nTas);
  }

  /*
   * Constructs an empty priority queue.
   */
  public FilePrioriteTas() {
    tas = (E[]) new Object[defaultSize];
  }

  /*
   * Constructs an empty priority queue with the specified initial capacity.
   */
  public FilePrioriteTas(int size) {
    tas = (E[]) new Object[size];
  }

  /*
   * Returns a string representation of the object.
   */
  @Override
  public String toString() {
    String str = "[";
    for (int i = 0; i < tas.length; i++) {
      if (tas[i] == null) {
        break;
      }
      str += tas[i];
      if (i < tas.length - 1 && tas[i + 1] != null) {
        str += ", ";
      }
    }
    str += "]";
    return str;
  }

  /*
   * Removes all of the elements from this priority queue.
   */
  @Override
  public void clear() {
    tas = (E[]) new Object[tas.length];
  }

  /*
   * Dans le cas où les éléments stockés ne sont pas comparables (au sens Comparable<E>, il faut fournir un Comparator<E> au constructeur du tas. Ajoutez un attribut pour garder trace de ce comparateur et faites une méthode privée qui émule la comparaison que les éléments soient comparables ou pas : private int compare(E e1, E e2). (Cette méthode ne peut pas être statique car elle utilise le type générique E, et le comparateur.) 
   */
  private Comparator<? super E> comparator;

  public FilePrioriteTas(Comparator<? super E> comparator) {
    this();
    this.comparator = comparator;
  }

  private int compare(E e1, E e2) {
    if (comparator != null) {
      return comparator.compare(e1, e2);
    } else if (e1 instanceof Comparable) {
      return ((Comparable<E>) e1).compareTo(e2);
    } else {
      throw new IllegalArgumentException("Elements are not comparable and no comparator provided");
    }
  }

  @Override
  public Comparator<? super E> comparator() {
    return comparator;
  }

  /*
   * Updates the priority queue from the specified position.
   */
  private void updateTas(int position, boolean up) {
    if (up) {
      if (position == 0) {
        return;
      }

      int parent = (position - 1) / 2;
      if (compare(tas[position], tas[parent]) > 0) {
        E temp = tas[position];
        tas[position] = tas[parent];
        tas[parent] = temp;
        updateTas(parent, up);
      }

    } else {
      int left = 2 * position + 1;
      int right = 2 * position + 2;
      int max = position;

      if (left < tas.length && compare(tas[left], tas[max]) > 0) {
        max = left;
      }

      if (right < tas.length && compare(tas[right], tas[max]) > 0) {
        max = right;
      }

      if (max != position) {
        E temp = tas[position];
        tas[position] = tas[max];
        tas[max] = temp;
        updateTas(max, up);
      }
    }
  }

  /*
   * Inserts the specified element into this priority queue.
   * If the queue is full, the element is not inserted and throws an exception.
   */
  @Override
  public boolean offer(E e) {
    // check if the queue is full
    if (tas[tas.length - 1] != null) {
      return false;
    }

    // insert the element at the first available position
    for (int i = 0; i < tas.length; i++) {
      if (tas[i] == null) {
        tas[i] = e;
        // update the queue
        updateTas(i, true);
        break;
      }
    }

    size++;
    return true;
  }

  /*
   * Returns the head of this queue, or returns null if this queue is empty.
   */
  @Override
  public E peek() {
    return tas[0];
  }

  /*
   * Returns and removes the head of this queue, or returns null if this queue is empty.
   */
  @Override
  public E poll() {
    if (tas[0] == null) {
      return null;
    }

    E head = tas[0];
    tas[0] = tas[tas.length - 1];
    tas[tas.length - 1] = null;
    updateTas(0, false);

    size--;
    return head;
  }

  /*
   * Returns the number of elements in this collection not counting the null elements.
   */
  @Override
  public int size() {
    return size;
  }

  /*
   * Returns <code>true</code> if this collection contains no elements.
   */
  @Override
  public boolean isEmpty() {
    return tas[0] == null;
  }
}