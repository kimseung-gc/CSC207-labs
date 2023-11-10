package Class21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.io.PrintWriter;

public class Experiments {
  final static int NUM = 2046;
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);
    String[] tmp = 
      new String[] {"alpha", "bravo", "charlie", "delta", "echo",
                    "foxtrot", "golf", "hotel", "india",
                    "juliett", "kilo", "lima", "mike", 
                    "november", "oscar", "papa", "quebec",
                    "romeo", "sierra", "tango", "uniform",
                    "victor", "whiskey", "xray", "yankee", "zulu"};
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));
    String ex1b = Utils.search(strings, (s) -> s.contains("u"));
    pen.println(ex1b);
    int[] temp = new int[NUM];
    // for(int i = 0; i < NUM; i++){
    //   temp[i] = 2*i;
    //   for(int j = 0; j <= i; j++){
    //     Utils.binarySearch(temp, 2*j, i+1, pen);
    //     Utils.binarySearch(temp, 2*j+1, i+1, pen);
    //   }
    //   Utils.binarySearch(temp, -1, i+1, pen);
    // }
    Integer[] smallarr = new Integer[]{7, 35, 40, -1, -5};
    pen.println(Utils.smallest(smallarr, (arg0, arg1) -> Integer.compareUnsigned(arg0, arg1)));
  }
}
