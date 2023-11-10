package Class10.testing;

import java.io.PrintWriter;

/**
 * A place to put experiments with our SampleMethods class.
 */
public class SampleMethodsExperiments {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    removeAsExperiments(pen);
  }

  /**
   * Experiments with `removeAs`.
   */
  public static void removeAsExperiments(PrintWriter pen) {
    removeAsExperiment(pen, "");
    removeAsExperiment(pen, "hello");
    removeAsExperiment(pen, "a");
    removeAsExperiment(pen, "aaaa");
    removeAsExperiment(pen, "pain");
    removeAsExperiment(pen, "alphabet");
    removeAsExperiment(pen, "aBaaCDaaaEFGaaaaHIJKaaaaLMNaaaOPaaQa");
    removeAsExperiment(pen, "aaabbbaaa");
  } // removeAsExperiments

  /**
   * A single experiment with `removeAs`.
   */
  public static void removeAsExperiment(PrintWriter pen, String str) {
    pen.print("removeAs(\"" + str + "\") = ");
    pen.flush();
    String tmp = SampleMethods.removeAs(str);
    pen.println("\"" + tmp + "\"");
  } // removeAsExperiment(PrintWriter, String)
} // class SampleMethodsExperiment
