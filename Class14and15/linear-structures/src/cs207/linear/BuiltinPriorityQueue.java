package cs207.linear;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Priority queues implemented with the standard Java Priority Queues. 
 * (I'd call this an adapter class, but it's implemented by delegating 
 * most of the methods.)
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class BuiltinPriorityQueue<T> implements PriorityQueue<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The underlying priority queue.
   */
  java.util.PriorityQueue<T> pq;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new priority queue that holds up to capacity elements and 
   * uses order to compare elements.
   */
  public BuiltinPriorityQueue(int capacity, Comparator<T> order) throws Exception {
    this.pq = new java.util.PriorityQueue<T>(capacity, order);
  } // BuiltinPriorityQueue(int capacity)

  // +------------------------+------------------------------------------
  // | Priority Queue Methods |
  // +------------------------+

  @Override
  public boolean isEmpty() {
    return pq.size() <= 0;
  } // isEmpty()

  @Override
  public boolean isFull() {
    // It looks like the standard ones don't fill
    return false;
  } // isFull()

  @Override
  public void put(T val) throws Exception {
    pq.add(val);
  } // put(T)

  @Override
  public T get() throws Exception {
    return (T) pq.remove();
  } // get(T)

  @Override
  public T peek() throws Exception {
    return (T) pq.peek();
  } // peek()

  @Override
  @SuppressWarnings({"unchecked"})
  // Handle different forms of comparator
  public Comparator<T> comparator() {
    return (Comparator<T>) pq.comparator();
  } // comparator()

  @Override
  public Iterator<T> iterator() {
    return pq.iterator();
  } // iterator()

} // class BuiltinPriorityQueue<T>
