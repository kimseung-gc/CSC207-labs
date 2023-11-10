package Class9.generics;

import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * A simple experiment with expandable arrays.
 */
public class SEAExpt {
  /**
   * Square a big integer.
   */
  public static BigInteger square(BigInteger i) {
    return i.multiply(i);
  } // square(BigInteger)

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    ExpandableArray<BigInteger> numbers = new SimpleExpandableArray<BigInteger>();
    
    // Set some values
    for (int i = 0; i < 10; i++) {
      numbers.set(i, BigInteger.valueOf(i));
    } // for i

    // Get some values
    for (int i = 0; i < 10; i++) {
      pen.println("numbers[" + i + "] = " + numbers.get(i));
    } // for i

    // Do some simple computations
    for (int i = 0; i < 10; i++) {
      pen.println(numbers.get(i) + "^2 = " + square(numbers.get(i)));
    } // for i

    ExpandableArray<String> strings = new SimpleExpandableArray<String>();

    for(int i = 0; i < 10; i++){
      strings.set(i, "씨발");
    }

    for (int i = 0; i < 10; i++) {
      pen.println("strings[" + i + "] = " + strings.get(i));
    } // for

  } // main(String[])
} // class SEAExpt

/* When experimented with no <String> or no <BigInteger>, the
 * VSCode shows warning signs, but it normally compiles. In fact,
 * if LHS and RHS does not have the declaration, it surprisingly
 * still works.
 */