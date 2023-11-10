package Class9.generics;

/**
 * Predicates for small strings.  Uses a form of the Singleton pattern.
 * Clients cannot create SmallString objects; they must reference 
 * SmallString.PRED.
 * 
 * @author Samuel A. Rebelsky
 *
 */
public class OddInteger implements Predicate<Integer> {
  public boolean holds(Integer val) {
    return (val % 2) == 1;
  } // holds
  public static final OddInteger PRED = new OddInteger();
  private OddInteger() { }
} // class OddInteger