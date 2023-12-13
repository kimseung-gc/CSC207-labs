import java.util.Iterator;

/**
 * Simple linear structures, which let you add and remove items one at a time.
 *
 * @author Samuel A. Rebelsky
 */
public interface LinearStructure<T> extends Iterable<T> {
  /**
   * Add an element to the structure.
   *
   * @param val the value to add.
   * @pre !this.isFull()
   * @post The element has been added to the structure. 
   * @exception Exception If the structure is full.
   */
  public void put(T val) throws Exception;

  /**
   * Remove an element from the structure according to the underlying policy.
   *
   * @return val, a value.
   * @pre !this.isEmpty()
   * @post The structure contains one fewer copy of val.
   * @exception Exception If the structure is empty.
   */
  public T get() throws Exception;

  /**
   * Determine what element will next be removed by get.
   *
   * @return val, a value.
   * @pre !this.isEmpty()
   * @post The next call to this.get() returns val.
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
} // interface LinearStructure
