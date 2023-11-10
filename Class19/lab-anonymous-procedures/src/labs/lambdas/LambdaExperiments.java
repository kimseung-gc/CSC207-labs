package labs.lambdas;

import java.util.function.Predicate;
import java.util.function.Function;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * LambdaExperiments.java
 *
 * A variety of experiments for working with lambdas. 
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 * @author Your Name Here
 */
public class LambdaExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String[] tmp =
      new String[] { "alpha", "bravo", "charlie", "delta", "echo",
                     "foxtrot", "golf", "hotel", "india",
                     "juliett", "kilo", "lima", "mike",
                     "november", "oscar", "papa", "quebec",
                     "romeo", "sierra", "tango", "uniform",
                     "victor", "whiskey", "xray", "yankee", "zulu" };
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));
    pen.println(strings.size());
    ArrayList<String> stringTmp = ListUtils.select(strings, new Predicate<String>() {
      public boolean test(String t) {
        Boolean tmp2 = false;
        Character[] vowels = new Character[] {'a', 'e', 'i', 'o', 'u'};
        ArrayList<Character> tmp = new ArrayList<Character>(Arrays.asList(vowels));
        for(Character c : t.toCharArray()){
          if(tmp.contains(c) && tmp2){
            return true;
          }else if(tmp2){
            tmp2 = false;
          }else if(tmp.contains(c)){
            tmp2 = true;
          }
        }
        return tmp2;
      }
    });
    for(int i = 0; i < stringTmp.size(); i++){
      pen.println(stringTmp.get(i));
    }
  } // main(String[])
} // class LambdaExperiments
