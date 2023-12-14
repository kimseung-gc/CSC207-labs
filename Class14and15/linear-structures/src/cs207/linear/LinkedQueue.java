import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple linked queue.
 *
 * @author Samuel A. Rebelsky
 * @author Hyeon Kim
 */
public class LinkedQueue<T> implements Queue<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The front of the queue.
   */
  Node<T> front;
  
  /**
   * The back of the queue.
   */
  Node<T> back;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new queue.
   */
  public LinkedQueue() {
    this.front = null;
    this.back = null;
  } // LinkedQueue(int)

  // +-------------------------+-----------------------------------------
  // | LinearStructure Methods |
  // +-------------------------+

  @Override
  public boolean isEmpty() {
    return this.front == null;
  } // isEmpty()

  @Override
  public boolean isFull() {
    return false;
  } // isFull()

  @Override
  public T peek() throws Exception {
    return this.front.value;
  } // peek()

  @Override
  public void put(T val) throws Exception {
    Node<T> last = new Node<T>(val, null);
    if(this.isEmpty())
    {
      this.front = last;
      this.back = last;
    }
    else
    {
      this.back.next = last;
      this.back = last;
    }
  } // put(T)

  @Override
  public T get() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("cannot get values from the empty queue");
    } // if empty
    T result = this.front.value;
    this.front = this.front.next;
    if(this.front == null){
      this.back = null;
    }
    return result;
  } // get()

  @Override
  public Iterator<T> iterator() {
    return new LinkedQueueIterator<T>(this);
  } // iterator()

  // +---------------+---------------------------------------------------
  // | Queue Methods |
  // +---------------+

  @Override
  public void enqueue(T val) throws Exception {
    this.put(val);
  } // enqueue(T)

  @Override
  public T dequeue() throws Exception {
    return this.get();
  } // dequeue()

} // LinkedQueue<T>


class LinkedQueueIterator<T> implements Iterator<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The next node in the iteration.
   */
  Node<T> next;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new iterator.
   */
  public LinkedQueueIterator(LinkedQueue<T> lq) {
    this.next = lq.front;
  } // LinkedQueueIterator

  // +---------+---------------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public T next() throws NoSuchElementException {
    T result = this.next.value;
    this.next = this.next.next;
    return result;
  } // next()

  @Override
  public boolean hasNext() {
    return (this.next != null);
  } // hasNext()

  @Override
  public void remove() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  } // remove()
} // LinkedQueueIterator<T>
