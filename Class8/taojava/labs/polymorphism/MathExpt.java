package Class8.taojava.labs.polymorphism;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * A few simple experiments with our utilities.
 */
public class MathExpt
{
  public static void main(String[] args)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    Integer smp1 = 5;
    Float smp2 = 341552.6463f;
    double smp3 = 5.9923;
    BigInteger smp4 = BigInteger.valueOf(6746465962812772773l);
    BigDecimal smp5 = BigDecimal.valueOf(0.0000000000000001442);
    Double smp6 = 0.00000535;
    // Print some square roots.
    for (int i = 2; i < 10; i++)
      {
        double root = MathUtils.squareRoot(i);
        pen.println("The square root of " + i + " seems to be " + root);
        pen.println(root + "^2 = " + (root * root));
      } // for i
    double root = MathUtils.squareRoot(smp1);
    pen.println("The square root of " + smp1 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    root = MathUtils.squareRoot(smp2);
    pen.println("The square root of " + smp2 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    root = MathUtils.squareRoot(smp3);
    pen.println("The square root of " + smp3 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    root = MathUtils.squareRoot(smp4);
    pen.println("The square root of " + smp4 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    root = MathUtils.squareRoot(smp5); // On values smaller than 1, the sqrt function does not work as the sqrt function is incrementing on numbers smaller than 1.
    pen.println("The square root of " + smp5 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    root = MathUtils.squareRoot(smp6);
    pen.println("The square root of " + smp6 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt
