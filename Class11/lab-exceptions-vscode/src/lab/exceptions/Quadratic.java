package lab.exceptions;

/**
 * Quadratic expressions (of the form ax^2 + bx + c).
 * 
 * @author Samuel A. Rebelsky
 * @author YOUR NAME HERE
 */
public class Quadratic {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  
  /**
   * The coefficient of the x^2 component.
   */
  double a;

  /**
   * The coefficient of the x component.
   */
  double b;

  /**
   * The constant.
   */
  double c;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new quadratic.
   */
  public Quadratic(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  } // Quadratic(double, double, double)

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Convert to a string.
   */
  public String toString() {
    return a + "x^2 + " + b + "x + " + c;
  } // toString()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Build a string that shows the expression with a particular value.
   */
  public String toString(double val) {
    return a + "*" + val + "^2" + "+" + b + "*" + val + "+" + c;
  } // toString(double)
  
  /**
   * Evaluate the quadratic on a value.
   */
  public double evaluate(double x) {
    return this.a*x*x  + this.b*x + this.c;
  } // evaluate(double)

  /**
   * Find the smaller of the two roots.
   */
  public double smallerRoot() {
    try{
      double det = this.b*this.b-4*this.a*this.c;
      double ret = (-this.b-Math.sqrt(det))/(2*this.a);
      return ret;
    }catch(Exception e){
      return Double.MAX_VALUE;
    }
  } // smallerRoot

  /**
   * Find the larger of the two roots.
   */
  public double largerRoot() {
    try{
      double det = this.b*this.b-4*this.a*this.c;
      double ret = (-this.b+Math.sqrt(det))/(2*this.a);
      return ret;
    }catch(Exception e){
      return Double.MAX_VALUE;
    }
  } // largerRoot
} // class Quadratic
