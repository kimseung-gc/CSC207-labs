package Class10.testing;

/**
 * A variety of methods for which students should write tests.
 * 
 * @author Spencer Liberto
 * @author Samuel A. Rebelsky
 * @author Lea Marolt Sonnenschein
 * @author Daniel Torres
 */
public class SampleMethods {
  /**
   * Convert from Celsius to Fahrenheit.
   * 
   * @param temp The temperature in Celsius.
   * @return The temperature in Fahrenheit.
   */
  public static int c2f(int temp) {
    return (temp * (9 / 5) + 32);
  } // c2f(int)

  /**
   * Compute x^p.
   * 
   * @param x an integer
   * @param p a non-negative integer
   * @return x^p
   * @pre {@code Integer.MIN_VALUE < x^p < Integer.MAX_VALUE}
   */
  public static int expt(int x, int p) {
    // Base case: When p = 0, result is 1
    if (p == 0) {
      return 1;
    } // if (p == 0)
    // Base case: When p = 1, result is x
    else if (p == 1) {
      return x;
    } // if (p == 1)
    // Recursive case: When p is 2k, x^(2k) = (x^k) * (x^k)
    else if (p % 2 == 0) {
      int tmp = expt(x, p / 2);
      return tmp * tmp;
    } // if (p is even)
    // Recursive case: When p is odd, result is x*(x^(p-1))
    else {
      return x * expt(x * x, (p - 1) / 2);
    } // if p is odd.
  } // expt(int,int)

  /**
   * Compute x^p.
   * 
   * @param x a real number
   * @param p a non-negative integer
   * @return an approximation of x^p
   */
  public static double expt(double x, int p) {
    // Base case: When p = 0, result is 1
    if (p == 0) {
      return 1;
    } // if p is 0
    // Base case: When p = 1, result is x
    else if (p == 1) {
      return x;
    } // if p is 1
    // Recursive case: When p is 2k, x^(2k) = (x^k) * (x^k)
    else if (p % 2 == 0) {
      double tmp = expt(x, p / 2);
      return tmp * tmp;
    } // if p is even
    // Recursive case: When p is odd, result is x*(x^(p-1))
    else {
      return x*expt(x * x, (p - 1) / 2);
    } // if p is odd
  } // expt(double,int)

  /**
   * Remove all of the instances of the letter 'a' from a string.
   * 
   * @param str a string
   * @return no_as, the string without the letter 'a'
   * @pre No additional
   * @post If c appears in str, and c != 'a', then c appears in no_as.
   * @post For all 0 &lt;= i &lt; j &lt; str.length(), If str[i] != 'a' and str[j] != 'a', then
   *       there exist 0 &lt;= k &lt; l &lt; no_as.length() such that no_as[k] = str[i] and no_as[l] =
   *       str[j].
   */
  public static String removeAs(String str) {
    String no_as = ""; // The string we're creating with no a's.

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != 'a') {
        no_as += str.charAt(i);
      } // if we see the a
    } // for each position

    return no_as;
  } // removeAs

  /**
   * Remove all of the instances of the letter 'b' from a string.
   * 
   * @param str a string
   * @return no_bs, the string without the letter 'b'
   * @pre No additional
   * @post If c appears in str, and c != 'b', then c appears in no_bs.
   * @post For all 0 &lt;= i &lt; j &lt; str.length(), If str[i] != 'b' and str[j] != 'b', then
   *       there exist 0 &lt;= k &lt; l &lt; no_bs.length() such that no_bs[k] = str[i] and no_bs[l] =
   *       str[j].
   */
  public static String removeBs(String str) {
    StringBuffer no_bs = new StringBuffer(str);
    int iter = 0;
    for (int i = 0; i < str.length(); i++) {
      if (no_bs.charAt(i - iter) == 'b') {
        no_bs.deleteCharAt(i - iter);
        iter++;
      } // if the char at position i is a 'b'
    } // for each position in the string

    return no_bs.toString();
  } // removeBs(String word)

  /**
   * Sum all of the integers in an array.
   * 
   * @param ints an array of integers
   * @return result, an integer
   * @pre ints[0] + ints[1] + ... + ints[ints.length-1] < maxint
   * @post result = ints[0] + ints[1] + ... + ints[ints.length-1]
   */
  public static int sum(int[] ints) {
    int result = 0;

    for (int i = 0; i < ints.length; i++) {
      result += ints[i];
    } // for
    
    return result;
  } // result(int[])

} // class SampleMethods
