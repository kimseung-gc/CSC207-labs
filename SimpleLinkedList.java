package taojava.lists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Simple singly-linked lists.
 *
 * Note that these lists follow the same iterator policy as Java's
 * LinkedLists.  In particular, "The iterators returned by this class's
 * iterator and listIterator methods are fail-fast: if the list is
 * structurally modified at any time after the iterator is created,
 * in any way except through the iterator's own remove or add methods,
 * the iterator will throw a ConcurrentModificationException. Thus, in
 * the face of concurrent modification, the iterator fails quickly and
 * cleanly, rather than risking arbitrary, non-deterministic behavior at
 * an undetermined time in the future."
 *
 * Because these lists are singly linked, the next, add, and remove 
 * methods are generally O(1).  However, the previous method is likely
 * to be significantly more expensive, potentially O(n).
 */
public class SimpleLinkedList<T>
    implements SimpleList<T>
{
  // +-------+-------------------------------------------------------------
  // | Notes |
  // +-------+

  /*
    We keep a dummy node at the beginning of the list so that it's easier
    to do a number of the operations.

    Iterators are always on the node immediately prior to the node we're
    adding.
   */

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The dummy node at the front of the list.
   */
  Node front;

  /**
   * The number of modifications to the list.  Used to determine
   * whether an iterator is valid.
   */
  long mods;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create an empty list.
   */
  public SimpleLinkedList()
  {
    this.front = new Node(null, null);
    this.mods = 0;
  } // SimpleLinkedList

  // +-----------+---------------------------------------------------------
  // | Iterators |
  // +-----------+

  public Iterator<T> iterator()
  {
    return listIterator();
  } // iterator()

  public ListIterator<T> listIterator()
  {
    return new ListIterator<T>()
      {
        // +--------+------------------------------------------------------
        // | Fields |
        // +--------+

        /**
         * The node that immediately precedes the value to be returned 
         * by next.
         */
        Node cursor = SimpleLinkedList.this.front;

        /**
         * The position in the list. (Included because the folks 
         * at Sun/Oracle decided that list iterators need to be 
         * able to return integer indices.)
         */
        int pos = 0;

        /**
         * The number of modifications at the time this iterator was
         * created or last updated.
         */
        long mods = SimpleLinkedList.this.mods;

        // +---------+-----------------------------------------------------
        // | Helpers |
        // +---------+

        /**
         * Determine if the list has been updated since this iterator
         * was created or modified.
         */
        void failFast()
        {
          if (this.mods != SimpleLinkedList.this.mods)
            throw new ConcurrentModificationException();
        } // failFast

        // +---------+-----------------------------------------------------
        // | Methods |
        // +---------+

        public void add(T val)
          throws UnsupportedOperationException
        {
          failFast();

          // We add immediately after this node.
          this.cursor.next = new Node(val, this.cursor.next);

          // Advance over this node
          this.cursor = this.cursor.next;
          ++this.pos;

          // Note that we've updated so that the other iterators
          // will know.
          SimpleLinkedList.this.mods++;
          this.mods = SimpleLinkedList.this.mods;
        } // add(T)

        public boolean hasNext()
        {
          failFast();
          return this.cursor.next != null;
        } // hasNext()

        public boolean hasPrevious()
        {
          failFast();
          return this.pos - 1 >= 0;
        } // hasPrevious()

        public T next()
          throws NoSuchElementException
        {
          failFast();
          if (!this.hasNext())
            throw new NoSuchElementException();
          // Advance to the next node.
          this.cursor = this.cursor.next;
          this.pos++;
          // The next value is in the current node.
          return this.cursor.data;
        } // next()

        public int nextIndex()
        {
          failFast();
          return this.pos+1;
        } // nextIndex()

        public int previousIndex()
        {
          failFast();
          return this.pos - 1;
        } // prevIndex

        public T previous()
          throws NoSuchElementException
        {
          failFast();
          if (!this.hasPrevious())
            throw new NoSuchElementException();
          Node temp = SimpleLinkedList.this.front.next;
          for(int i = 0; i < this.previousIndex(); i++){
            temp = temp.next;
          }
          this.cursor = temp;
          this.pos--;
          return temp.data;
        } // previous()

        public void remove()
          throws UnsupportedOperationException,
            IllegalStateException
        {
          failFast();
          // Note that we've updated so that the other iterators
          // will know.
          SimpleLinkedList.this.mods++;
          this.mods = SimpleLinkedList.this.mods;
          // Do the real work.
          // STUB
          throw new UnsupportedOperationException();
        } // remove()

        public void set(T val)
          throws UnsupportedOperationException,
            ClassCastException,
            IllegalArgumentException,
            IllegalStateException
        {
          failFast();
          this.cursor.data = val;
          SimpleLinkedList.this.mods++;
          this.mods = SimpleLinkedList.this.mods;
        } // set(T)
      };
  } // listIterator()

  // +---------------+-----------------------------------------------------
  // | Inner Classes |
  // +---------------+

  /**
   * Nodes in the linked list.
   */
  class Node
  {
    // +--------+-----------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The data stored in the node.
     */
    T data;

    /**
     * The next node in the list.  Set to null at the end of the list.
     */
    Node next;

    // +--------------+-----------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a new node with specified data and next.
     */
    public Node(T data, Node next)
    {
      this.data = data;
      this.next = next;
    } // Node(T, Node)
  } // class Node

} // class SimpleLinkedList<T>

