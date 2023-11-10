package Class21;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.function.Predicate;


public class Utils {
  /**
   * Search values for the first value for which pred holds.
   */
  public static <T> T search(Iterable<T> values, Predicate<? super T> pred) throws Exception {
    for (T each : values) {
      if (pred.test(each)) {
        return each;
      }
    }
    return null;
  } // search(Iterable<T>, Predicate<? super T>)

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values A sorted array of integers
   * @param val An integer we're searching for
   * @result index, an integer
   * @throws Exception If there is no i s.t. values[i] == val
   * @pre values is sorted in increasing order. That is, values[i] < values[i+1] for all reasonable
   *      i.
   * @post values[index] == val
   */
  public static int binarySearch(int[] vals, int i, int max, PrintWriter pen) throws Exception {
    int min = 0;
    int count = 0;
    while (max > min) {
      int midInd = (int) ((max + min) / 2);
      if (vals[midInd] == i) {
        pen.println(count);
        return midInd;
      } else if (i < vals[midInd]) {
        max = midInd - 1;
      } else if (i > vals[midInd]) {
        min = midInd + 1;
      }
      count++;
    }
    pen.println(count);
    return -1;
  } // binarySearch


  public static int binarySearchRec(int[] vals, int i, int min, int max, int count, PrintWriter pen)
      throws Exception {
    count++;
    int midInd = (int) ((min + max) / 2);
    if (max < min) {
      pen.println(count);
      throw new Exception(i + "not found");
    }
    if (vals[midInd] == i) {
      pen.println(count);
      return midInd;
    } else if (vals[midInd] < i) {
      return binarySearchRec(vals, i, midInd + 1, max, count, pen);
    } else {
      return binarySearchRec(vals, i, min, midInd - 1, count, pen);
    }
  } // binarySearch

  /**
   * Find the "smallest" integer in an array of integers
   */
  public static Integer smallest(Integer[] values, Comparator<Integer> compare) {
    Integer smallestNum = values[0];
    for (Integer each : values) {
      if (compare.compare(each, smallestNum)>0){
        smallestNum = each;
      }
    }
    return smallestNum;
  } // smallest(Integer[])
}
