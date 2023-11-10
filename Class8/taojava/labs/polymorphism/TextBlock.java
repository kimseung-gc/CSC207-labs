package Class8.taojava.labs.polymorphism;

/**
 * Blocks of text.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.1 of February 2014
 */
public interface TextBlock
{
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception
   *              if the row number is invalid.
   */
  public String row(int i)
    throws Exception;

  /**
   * Determine how many rows are in the block.
   */
  public int height();

  /**
   * Determine how many columns are in the block.
   */
  public int width();

} // interface TextBlock
