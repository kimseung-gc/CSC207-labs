package cs207.linear;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Priority queues implemented with arrays.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class ArrayBasedPriorityQueue<T> implements PriorityQueue<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The values stored in the queue.
   */
  T[] values;

  /**
   * The number of elements in the queue.
   */
  int size;

  /**
   * The comparator used to determine order.
   */
  Comparator<T> order;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new priority queue that holds up to `capacity` elements and 
   * uses `order` to compare elements.
   */
  @SuppressWarnings({"unchecked"})
  // Handle array casting
  public ArrayBasedPriorityQueue(int capacity, Comparator<T> order) throws Exception {
    if (capacity <= 0) {
      throw new Exception("Queues must have a positive capacity.");
    } // if (capacity <= 0)
    // Yay Java! It's not possible to say new T[capacity], so
    // we use this hack and suppress warnings (see annotation)..
    this.values = (T[]) new Object[capacity];
    this.order = order;
    this.size = 0;
  } // ArayBasedQueue(int capacity)

  // +------------------------+------------------------------------------
  // | Priority Queue Methods |
  // +------------------------+

  @Override
  public boolean isEmpty() {
    return this.size <= 0;
  } // isEmpty()

  @Override
  public boolean isFull() {
    return this.size >= this.values.length;
  } // isFull()

  @Override
  public void put(T val) throws Exception {
    if (this.isFull()) {
      throw new Exception("no more room!");
    } // this.isFull()
    this.values[this.size++] = val;
  } // put(T)

  @Override
  public T get() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("empty");
    } // if empty
    // STUB! Needs reimplmentation.
    return this.values[--this.size];
  } // get(T)

  @Override
  public T peek() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("empty");
    } // if empty
    return this.values[this.size - 1];
  } // peek()

  @Override
  public Comparator<T> comparator() {
    return this.order;
  } // comparator()

  @Override
  /**
   * Build an iterator that returns the values of the priority queue, 
   * but not necessarily in priority order.
   */
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      @Override
      public T next() throws NoSuchElementException {
        if (!this.hasNext()) {
          throw new NoSuchElementException("no elements remain");
        } // if no elements
        // STUB
        throw new NoSuchElementException("unimplemented");
      } // next()

      @Override
      public boolean hasNext() {
        // STUB
        return false;
      } // hasNext()

      @Override
      public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
      } // remove()
    }; // new Iterator<T>()
  } // iterator()

} // class ArrayBasedPriorityQueue<T>
