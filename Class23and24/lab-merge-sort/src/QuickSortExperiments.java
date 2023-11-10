import java.util.Comparator;
import java.util.Arrays;

public class QuickSortExperiments {
  public static void main(String[] args) {
    Integer[] vals = new Integer[] {3,9,2,8,6,4,4,1,7,5};
    Comparator<Integer> compareInts = (x, y) -> x.compareTo(y);
    QuickSorter.quickSort(vals, compareInts);
    System.err.println(Arrays.toString(vals));
  }
}
