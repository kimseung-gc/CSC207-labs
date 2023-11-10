package Class9.generics;

/**
 * Predicates for small strings.  Uses a form of the Singleton pattern.
 * Clients cannot create SmallString objects; they must reference 
 * SmallString.PRED.
 * 
 * @author Samuel A. Rebelsky
 *
 */
public class SmallString implements Predicate<String> {
  public boolean holds(String val) {
    return val.length() < 5;
  } // holds
  public static final SmallString PRED = new SmallString();
  private SmallString() { }
} // class SmallString