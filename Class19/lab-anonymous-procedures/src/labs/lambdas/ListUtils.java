package labs.lambdas;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ListUtils.java
 *
 * A variety of utilities for working with lists, developed as an
 * experiment in working with anonymous procedures.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 * @author Your Name Here
 */
public class ListUtils {

  /**
   * Select all the elements of vals for which pred holds.
   */
  public static <T> ArrayList<T> select(List<T> vals, Predicate<T> pred) {
    ArrayList<T> temp = new ArrayList<T>(vals.size());
    for(T val : vals){
      if(pred.test(val)){
        temp.add(val);
      }
    }
    return temp;
  } // select(List<T>, Predicate<T>)

  /**
   * Remove all the elements of vals for which pred holds.
   */
  public static <T> void remove(List<T> vals, Predicate<T> pred) {
    // STUB
  } // remove(List<T>, Predicate<T>

  /**
   * Find the "largest" (most extreme) value of vals.
   */
  public static <T> T largest(List<T> vals, Comparator<T> compare) {
    return null;        // STUB
  } // largest(List<T>, Comparator<T>)

  /**
   * Everyone knows what map does, right?
   */
  public static <T,R> ArrayList<R> map(Function<T,R> fun, List<T> vals) {
    return null;
  } // map(Function<T,R>, List<T>) 

} // class ListUtils
