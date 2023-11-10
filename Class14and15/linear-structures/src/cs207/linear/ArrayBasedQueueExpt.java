package cs207.linear;

import java.io.PrintWriter;

/**
 * A very simple experiment with ArrayBasedQueues.
 *
 * @author Samuel A. Rebelsky.
 */
public class ArrayBasedQueueExpt {
  /**
   * Do all the work. (Well, make the helpers do all the work.)
   */
  public static void main(String[] args) throws Exception {
    ReportingLinearStructure<String> expt =
        new ReportingLinearStructure<String>(new ArrayBasedQueue<String>(4), new PrintWriter(System.err, true), "ArrayBasedQueue<String> expt.");
    // Put in a few values, then remove two
    expt.isEmpty();
    expt.put("a");
    expt.peek();
    expt.put("b");
    expt.peek();
    expt.put("c");
    expt.peek();
    expt.get();
    expt.peek();
    expt.get();
    expt.put("x");
    expt.peek();
    expt.get();
    expt.get();

    // We've put and get the same number of elements, it
    // should be empty
    expt.isEmpty();

    // It's always good to see what happens after you've cleared
    // out a structure. So add a few more elements.
    // We'll leave this test until we've worked out some kinks (Dave?)
    expt.put("e");
    expt.peek();
    expt.put("f");
    expt.get();
    expt.peek();
    expt.put("g");
    expt.get();
    expt.get();
    // And we're back down to the empty queue
    expt.isEmpty();

    //ReportingLinearStructure<ArrayBasedQueue> temp = new ReportingLinearStructure<ArrayBasedQueue>(expt);

    /*
    // An iteration experiment, once we've workd out some kinks (Ray?)
    expt.put("a");
    expt.put("b");
    expt.put("c");
    for (String s : expt) {
      System.out.println(s);
    } // for
    expt.get();
    expt.get();
    expt.get();
     */
    
    /*
    // Future tests, once we've worked out some more kinks (Pete
    // and Mick?)
    LinearStructureExpt.expt01(new ArrayBasedQueue<String>(8), "size08.");
    LinearStructureExpt.expt01(new ArrayBasedQueue<String>(4), "size04.");
    */
  } // main(String[])
} // class ArrayBasedQueueExpt
