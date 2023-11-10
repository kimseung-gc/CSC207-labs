import java.io.PrintWriter;
import java.util.ListIterator;

/**
 * Some simple experiments with SimpleLists
 */
public class SimpleListExpt {
  /**
   * Add an element using an iterator.
   */
  static void add(PrintWriter pen, ListIterator<String> it, String val)
      throws Exception {
    pen.println("Add \"" + val + "\" at position " + it.nextIndex());
    it.add(val);
  } // add(PrintWriter)

  /**
   * Print a list.
   */
  static void printList(PrintWriter pen, SimpleList<String> lst) {
    int i = 0;
    for (String val : lst) {
      pen.println(i++ + ": " + val);
    } // for
  } // printList(PrintWriter, SimpleList<String>)

  /**
   * Add a variety of elements.
   */
  static void expt(PrintWriter pen, SimpleList<String> lst, String[] vals)
      throws Exception {
    pen.println("Current list: ");
    printList(pen, lst);
    pen.println();

    ListIterator<String> lit = lst.listIterator();

    for (int i = 0; i < vals.length; i++) {
      add(pen, lit, vals[i]);
      printList(pen, lst);
      pen.println();
    } // for
  } // expt(PrintWriter, SimpleList<String>, String[])

  /**
   * My default experiment.
   */
  static void expt(PrintWriter pen, SimpleList<String> lst) throws Exception {
    expt(pen, lst, new String[] {"alpha", "bravo", "charlie"});
    expt(pen, lst, new String[] {"aardvark", "anteater", "antelope"});
  } // expt(PrintWriter, SimpleList<String>)
} // class SimpleListExpt
