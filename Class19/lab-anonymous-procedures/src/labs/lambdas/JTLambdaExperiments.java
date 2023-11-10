package labs.lambdas;

import java.util.function.Predicate;
import java.util.function.Function;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * JTLambdaExperiments.java
 *
 * A variety of experiments for working with lambdas, based on the
 * Java Tutorial on lambda expressions, available at 
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 * @author Your Name Here
 */
public class JTLambdaExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    List<Person> roster = Person.createRoster();
    for(int i=0; i < roster.size()-1; i++){
      pen.println(Person.compareByAge(roster.get(i), roster.get(i+1)));
    }
  } // main(String[])

  // +--------------------------------+------------------------------
  // | Methods from the Java Tutorial |
  // +--------------------------------+

} // class JTLambdaExperiments
