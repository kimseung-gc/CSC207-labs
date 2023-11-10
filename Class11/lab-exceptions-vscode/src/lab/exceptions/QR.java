package lab.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import org.junit.Test;

public class QR {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));

    int a = IOUtils.readInt(pen, eyes, "Please enter integer for x^2 coefficient: ");
    int b = IOUtils.readInt(pen, eyes, "Please enter integer for x^1 coefficient: ");
    int c = IOUtils.readInt(pen, eyes, "Please enter integer for x^0 coefficient: ");
    Quadratic quad = new Quadratic(a, b, c);
    double smR = quad.smallerRoot();
    double lgR = quad.largerRoot();
    pen.println("The smaller root of this equation is: " + smR);
    pen.println("The larger root of this equation is: " + lgR);
    pen.println("The smaller root evaluates to: " + quad.evaluate(smR));
    pen.println("The larger root evaluate to: " + quad.evaluate(lgR));
  }
}
