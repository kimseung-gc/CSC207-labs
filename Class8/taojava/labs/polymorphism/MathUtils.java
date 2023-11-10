package Class8.taojava.labs.polymorphism;

/**
 * A collection of simple math utilities.
 */
public class MathUtils
{
  /**
   * Compute an approximate square root of num.
   * 
   * @pre num > 1.0
   * @post the square of the result is within .01 of num.
   */
  public static double squareRoot(Number num)
  {
    double n = num.doubleValue();
    double lower = 0.0;
    double upper = n;
    if(n>1){
      while (upper - lower > 0.00001)
        {
          double mid = upper / 2.0 + lower / 2.0;
          if (mid * mid < n)
            lower = mid;
          else
            upper = mid;
        } // while
      return (upper + lower) / 2.0;
    }else{
      while (upper - lower > 0.00001)
        {
          double mid = upper / 2.0 + lower / 2.0;
          if (mid * mid < n)
            lower = mid;
          else
            upper = mid;
        } // while
      return 1;
    }
  } // squareRoot(Number)
} // class MathUtils
