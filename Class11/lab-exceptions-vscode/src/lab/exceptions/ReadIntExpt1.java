package lab.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import org.junit.Test;
/**
 * A simple experiment to see whether readInt works. (Unit tests are a PITA for
 * I/O.)
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class ReadIntExpt1 {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));

    int i = IOUtils.readInt(pen, eyes, "Please enter an integer: ");
    pen.println(i + " squared is " + (i * i));
  } // main(String[])

  @Test
  public void test1(){
    Quadratic quad = new Quadratic(1, 3, -10);
    assertEquals(-5, quad.smallerRoot());
  }

} // ReadIntExpt1
