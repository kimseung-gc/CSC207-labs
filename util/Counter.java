package Class12.util;

/**
 * Things that count.
 */
public interface Counter {
  /**
   * Count something.
   *
   * @exception Exception
   *   When the count gets too large.
   */
  public void increment() throws Exception;

  /**
   * Reset the counter.
   */
  public void reset();

  /**
   * Get the value of the counter.
   */
  public int get();
} // interface Counter