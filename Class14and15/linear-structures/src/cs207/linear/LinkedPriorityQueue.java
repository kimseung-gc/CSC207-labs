import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPriorityQueue<T> implements PriorityQueue<T> {
  /**
   * front node of the priority queue
   */
  Node<T> front;
  /**
   * Back node of the priority queue
   */
  Node<T> back;
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
  public LinkedPriorityQueue(Comparator<T> order) throws Exception {
    this.front = null;
    this.back = null;
    this.order = order;
  } // ArayBasedQueue(int capacity)

  // +------------------------+------------------------------------------
  // | Priority Queue Methods |
  // +------------------------+

  @Override
  public boolean isEmpty() {
    return (this.front == null);
  } // isEmpty()

  @Override
  public boolean isFull() {
    return false;
  } // isFull()

  @Override
  public void put(T val) throws Exception {
    if (this.isFull()) {
      throw new Exception("no more room!");
    } // this.isFull()
    if (this.isEmpty()) {
      this.front = new Node<T>(val, null);
      this.back = this.front;
    } // if
    this.back.next = new Node<T>(val, null);
    this.back = this.back.next;
  } // put(T)

  @Override
  public T get() throws NoSuchElementException {
    if (this.isEmpty()) {
      throw new NoSuchElementException("empty");
    } // if empty
    if (this.front == this.back) {
      T ret = this.front.value;
      this.front = null;
      this.back = null;
      return ret;
    } // if
    Node<T> maxPriority = this.front;
    for (Node<T> tempNode = this.front.next; tempNode != null; tempNode = tempNode.next) {
      if (comparator().compare(tempNode.value, maxPriority.value) <= 0) {
        maxPriority = tempNode;
      } // if
    } // for
    T ret = maxPriority.value;
    if (maxPriority == this.front) {
      Node<T> temp = this.front;
      this.front = this.front.next;
      temp.next = null;
      return ret;
    } // if
    Node<T> maxPrev = null;
    for (maxPrev = this.front; maxPrev.next != maxPriority; maxPrev = maxPrev.next) {
      continue;
    } // for
    maxPrev.next = maxPriority.next;
    maxPriority.next = null;
    return ret;
  } // get(T)

  @Override
  public T peek() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("empty");
    } // if empty
    return this.back.value;
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
        return get();
      } // next()

      @Override
      public boolean hasNext() {
        return !isEmpty();
      } // hasNext()

      @Override
      public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
      } // remove()
    }; // new Iterator<T>()
  } // iterator()
} // class LinkedPriorityQueue<T>
