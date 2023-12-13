import java.util.Comparator;
import java.util.Iterator;

/**
 * A linear structure that follows the "best first" policy.
 *
 * @author Samuel A. Rebelsky
 */
public interface PriorityQueue<T> extends LinearStructure<T> {
  /**
   * Add an element to the queue.
   *
   * @param val the value to add.
   * @pre !this.isFull()
   * @post The queue now contains an additional copy of val.
   * @exception Exception If the structure is full.
   */
  public void put(T val) throws Exception;

  /**
   * Remove the highest-priority element that is still in the queue.
   *
   * @return val, a value.
   * @pre !this.isEmpty()
   * @post The structure contains one fewer copy of val.
   * @post For all values, v, in the queue, comparator().compare(val, v) <= 0
   * @exception Exception If the structure is empty.
   */
  public T get() throws Exception;

  /**
   * Determine what element will next be removed by get.
   *
   * @return val, a value.
   * @pre !this.isEmpty()
   * @post For all values, v, in the queue, comparator().compare(val, v) <= 0
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
   * Get an iterator that returns all of the elements in some order (that is, not necessarily in
   * priority order).
   */
  public Iterator<T> iterator();

  /**
   * Determine what comparator is used by this priority queue.
   */
  public Comparator<T> comparator();
} // interface PriorityQueue<T>
