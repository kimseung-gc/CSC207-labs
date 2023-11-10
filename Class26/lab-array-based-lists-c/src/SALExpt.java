import java.io.PrintWriter;

/**
 * Some simple experiments with SimpleArrayLists.
 */
public class SALExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    SimpleListExpt.expt(pen, new SimpleArrayList<String>());
  } // main(String[])
} // SALExpt
