package Class8.taojava.labs.polymorphism;

import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils
{
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes.  This sequence may grow as
   * the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program
   * operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len)
  {
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len)
      {
        lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
      }
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block)
  {
    for (int i = 0; i < block.height(); i++)
      {
        // Even though we only call block.row with a valid i,
        // we need to put the call in a try/catch block.
        try
          {
            pen.println(block.row(i));
          } // try
        catch (Exception e)
          {
            pen.println();
          } // catch (Exception)
      } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len)
  {
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len)
      {
        lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
      } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

} // class TBUtils
