import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Very simple array-based lists.
 *
 * Note that these lists do not the same iterator policy as Java's
 * ArrayLists. In particular, "The iterators returned by this class's
 * iterator and listIterator methods are fail-fast: if the list is
 * structurally modified at any time after the iterator is created,
 * in any way except through the iterator's own remove or add methods,
 * the iterator will throw a ConcurrentModificationException.  Thus,
 * in the face of concurrent modification, the iterator fails quickly
 * and cleanly, rather than risking arbitrary, non-deterministic
 * behavior at an undetermined time in the future."  Our lists may
 * *not* fail fast.
 */
public class SimpleArrayList<T> implements SimpleList<T> {
  // +-----------+---------------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default initial capacity.
   */
  static final int DEFAULT_CAPACITY = 4;

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The array used to store the list elements.
   */
  T[] values;

  /**
   * The number of values actually in the list.
   */
  int size;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create an empty list.
   */
  public SimpleArrayList() {
    this.values = allocate(DEFAULT_CAPACITY);
    this.size = 0;
  } // SimpleArrayList

  // +-----------+---------------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Allocate an array of T's of size size.
   */
  @SuppressWarnings({"unchecked"})
  T[] allocate(int size) {
    return (T[]) new Object[size];
  } // allocate(int)

  // +-----------+---------------------------------------------------------
  // | Iterators |
  // +-----------+

  public Iterator<T> iterator() {
    return listIterator();
  } // iterator()

  public ListIterator<T> listIterator() {
    return new ListIterator<T>() {
      // +--------+--------------------------------------------------------
      // | Fields |
      // +--------+

      /**
       * The position in the list of the next value to be returned.
       */
      int pos = 0;

      // +---------+-------------------------------------------------------
      // | Helpers |
      // +---------+

      // +---------+-------------------------------------------------------
      // | Methods |
      // +---------+

      public void add(T val) throws UnsupportedOperationException {
        T[] vals = SimpleArrayList.this.values; // A shorter name

        // If the array is not big enough, expand it
        if (SimpleArrayList.this.size >= vals.length) {
          SimpleArrayList.this.values = Arrays.copyOf(vals, 2 * vals.length);
          vals = SimpleArrayList.this.values;
        } // if the array is not big enough

        // Shift everything to the right
        for (int i = SimpleArrayList.this.size; i > this.pos; i--) {
          vals[i] = vals[i - 1];
        } // for

        // Insert the new value
        vals[this.pos] = val;

        // Increase the size
        ++SimpleArrayList.this.size;

        // The semantics of add require that the element we just added
        // is *before* the next thing we return, that the iterator
        // remains after the thing we just added, that the value returned
        // by next is unchanged, and that the value returned by nextIndex
        // or prevIndex is increased by 1. Amazingly, one little operation
        // accomplishes all of those goals.
        ++this.pos;
      } // add(T)

      public boolean hasNext() {
        return (this.pos < SimpleArrayList.this.size);
      } // hasNext()

      public boolean hasPrevious() {
        return (this.pos > 0);
      } // hasPrevious()

      public T next() {
         if (!this.hasNext()) {
          throw new NoSuchElementException();
         } //
        return SimpleArrayList.this.values[this.pos++];
      } // next()

      public int nextIndex() {
        return this.pos;
      } // nextIndex()

      public int previousIndex() {
        return this.pos - 1;
      } // prevIndex

      public T previous() throws NoSuchElementException {
        if (!this.hasPrevious())
          throw new NoSuchElementException();
        // STUB
        return null;
      } // previous()

      public void remove() {
        // Do the real work.
        // STUB
        throw new UnsupportedOperationException();
      } // remove()

      public void set(T val) {
        // STUB
        throw new UnsupportedOperationException();
      } // set(T)
    };
  } // listIterator()
} // class SimpleArrayList<T>
