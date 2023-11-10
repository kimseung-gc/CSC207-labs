package Class9.generics;

import java.io.PrintWriter;

/**
 * A simple set of experiments with predicates and searching.
 */
public class SearchExpt {
  public static void main(String[] args) {
    // Prepare for output.
    PrintWriter pen = new PrintWriter(System.out, true);

    // Set up a few arrays to search.
    String[] strings = new String[] {"alpha", "bravo", "charlie", "delta", "echo", "foxtrot",
        "golf", "hotel", "india", "juliett", "kilo", "lima", "mike", "november", "oscar"};
    Integer[] numbers = new Integer[] {2, 3, 5, 7, 9, 11, 13, 15, 17, 18, 32, 42,};


    // Okay, we're ready for the experiments
    pen.println("A small string: " + SearchUtils.search(strings, SmallString.PRED));
    pen.println("An odd integer: " + SearchUtils.search(numbers, OddInteger.PRED));
  } // main(String[])

} // class SearchExpt

