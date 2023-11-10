package Class8.taojava.labs.polymorphism;

/**
 * One line of text.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of September 2014
 */
public class TextLine
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The contents of the line.
   */
  String line;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new line with the specified contents.
   */
  public TextLine(String line)
  {
    this.line = line;
  } // TextLine(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre i == 0
   * @exception Exception
   *              if i != 0
   */
  public String row(int i)
    throws Exception
  {
    if (i != 0)
      {
        throw new Exception("Invalid row " + i);
      } // if the row is invalid
    return this.line;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height()
  {
    return 1;
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width()
  {
    return this.line.length();
  } // width()

} // class TextLine
