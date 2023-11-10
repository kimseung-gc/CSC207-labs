import java.util.Arrays;
import java.util.Comparator;

/**
 * A simple way to sort arrays using merge sort.
 *
 * @author Seunghyeon (Hyeon) Kim
 * @author John Miller
 * @author Samuel A. Rebelsky
 */
public class MergeSorter {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator) {
    /* Call the helper function: merge. Call it such that it will sort the whole array. */
    merge(vals, 0, vals.length, comparator);
  } // sort

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array. This is the recursive helper function 
   * for the sort function.
   *
   * @pre vals must be the unsorted list, and a valid comparator for
   * generic type <T>. The lo and hi are the lower index and higher
   * index which the function sorts [lo, hi) region.
   * @post Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
    /* middle index is, by definition, (lo+hi)/2 rounded down */
    int mid = (lo + hi)/2;
    /* tempLen is the length of the sub array that the code is looking at */
    int tempLen = hi-lo;
    /* Base case */
    if(tempLen == 0  || tempLen == 1){
      /* When there is nothing more to call recursively, return vals */
      return;
    }
    /* Sort the first half of the vals recursively */
    merge(vals, mid, hi, comparator);
    /* Sort the latter half of the vals recursively */
    merge(vals, lo, mid, comparator);
    /* returning array, as it is a generic array, I used Arrays.copyOf() function */
    T[] ret = Arrays.copyOf(vals, vals.length);
    /* right half of the array by index */
    int r = mid;
    /* left half of the array by index */
    int l = lo;
    /* by iterating a for loop, sort the ret */
    for(int i = lo; i < hi; i++){
      /* When out of index, append the rest of the list at the end of ret */
      vals[i] = (((r == hi) && (l < mid))?                    ret[l++] : 
                (((l == mid) && (r < hi))?                    ret[r++] :
      /* By using the comparator, sort the vals (if ret[l] ≤ ret[r], vals[i] = ret[l]) */
                   (comparator.compare(ret[l], ret[r]) <= 0)? ret[l++] : 
      /* Else, vals[i] = ret[r] */
                                                              ret[r++]));
    } // for
    /* return the sorted array */
    return;
  } // merge
} // class MergeSorter