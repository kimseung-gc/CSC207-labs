package cs207.linear;

/**
 * A really simple experiment with ArrayBasedStacks.
 *
 * @author Samuel A. Rebelsky.
 */
public class ArrayBasedStackExpt {
  /**
   * Do all the work. (Well, make the helpers do all the work.)
   */
  public static void main(String[] args) throws Exception {
    LinearStructureExpt.expt01(new ArrayBasedStack<String>(16), "size16.");
    LinearStructureExpt.expt01(new ArrayBasedStack<String>(4), "size04.");
  } // main(String[])
} // class ArrayBasedStackExpt
