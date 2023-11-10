package cs207.linear;

import java.util.Iterator;

/**
 * A linear structure that follows the last-in, first-out policy.
 *
 * @author Samuel A. Rebelsky
 */
public interface Queue<T> extends LinearStructure<T> {
  /**
   * Add an element to the queue.
   *
   * @param val the value to add.
   * @pre !this.isFull()
   * @post The queue now contains an additional element of val.
   * @exception Exception If the structure is full.
   */
  public void put(T val) throws Exception;

  /**
   * Remove the least recently added element that is still in the queue.
   *
   * @return val, a value.
   * @pre !this.isEmpty()
   * @post The structure contains one fewer copy of val.
   * @post Every element that remains in the queue was added more 
           recently than val.
   * @exception Exception If the structure is empty.
   */
  public T get() throws Exception;

  /**
   * Determine what element will next be removed by get.
   *
   * @return val, a value.
   * @pre !this.isEmpty()
   * @post Every other value in the queue was added more recently than val.
   * @exception Exception If the structure is empty.
   */
  public T peek() throws Exception;

  /**
   * Determine if the structure is empty.
   */
  public boolean isEmpty();

  /**
   * Determine if the structure is full.
   */
  public boolean isFull();

  /**
   * Get an iterator that returns all of the elements in some order.
   */
  public Iterator<T> iterator();

  /**
   * Put a value at the end of the queue. (An alias for put.)
   */
  public void enqueue(T val) throws Exception;

  /**
   * Remove the value from the front of the queue. (An alias for get.)
   */
  public T dequeue() throws Exception;
} // interface Queue<T>
