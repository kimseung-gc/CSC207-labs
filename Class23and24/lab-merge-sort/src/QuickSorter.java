import java.util.Comparator;

/**
 * A simple way to sort arrays using merge sort.
 *
 * @author Seunghyeon (Hyeon) Kim
 * @author Jinny Eo
 * @author Samuel A. Rebelsky
 */
public class QuickSorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sorting function using the quickSort method. Generally has O(n log n) speed.
   * @param <T>
   * @param values
   * @param compare
   */
  public static <T> void quickSort(T[] values, Comparator<? super T> compare) {
    quickSortHelper(values, compare, 0, values.length);
  } // quickSort

  /**
   * It is a helper function for quickSort. It sorts values from index lb to ub-1.
   * @param <T>
   * @param values
   * @param compare
   * @param lb
   * @param ub
   */
  private static <T> void quickSortHelper(T[] values, Comparator<? super T> compare, int lb, int ub) {
    // Subarrays of one element or fewer are sorted.
    if (lb >= ub-1) {
      return;
    } else {
      int mid = partition(values, compare, lb, ub);
      quickSortHelper(values, compare, lb, mid);
      quickSortHelper(values, compare, mid+1, ub);
    } // if/else
  } // quickSort(T[], Comparator, int, int)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into 
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  private static <T> int partition(T[] arr, Comparator<? super T> compare, int lb, int ub) {
    if(lb == ub-1){
      /* When there is no more to partition, return the lb (the only possible index) */
      return lb;
    }
    /* Declare small and large as their initial values */
    int small = lb+1;
    int large = ub-1;

    /* midpoint as the initial pivot location */
    int pivotLoc = (lb+ub)/2;
    /* Send pivot value to the lower bound */
    swap(arr, lb, pivotLoc);
    /* run a loop as long as large index is bigger than small index */
    while(large > small){
      /* When small is correct in terms of how they are smaller than pivot value, pass this index */
      if(compare.compare(arr[small], arr[lb])<=0){
        small++;
      }else if(compare.compare(arr[lb], arr[large])<0){
      /* When large is correct in terms of how they are bigger than pivot value, pass this index */
        large--;
      /* Otherwise, the value at large index must be smaller than pivot value and the value at 
         small index must be bigger than or equal to pivot value, so swap them */
      }else{
        swap(arr, small, large);
      }
    } // while
    /* Lastly, compare the last index (large). If the value at this index is smaller than or equal to 
       pivot value, swap pivot value with large. Otherwise, swap with small-1. */
    pivotLoc = (compare.compare(arr[lb], arr[large]) >= 0)? large : small-1;
    swap(arr, pivotLoc, lb);
    /* Return the pivot location */
    return pivotLoc;
  } // partition

  /**
   * This function swaps the item in generic arr at index i and j.
   * @param <T>
   * @param arr
   * @param i
   * @param j
   */
  private static <T> void swap(T[] arr, int i, int j){
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return;
  } // swap
} // class MergeSorter