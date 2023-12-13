import java.io.PrintWriter;

/**
 * Experiments with LinearStructures.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class LinearStructureExpt {
  // +----------------+--------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * A series of experiments on a structure of strings.
   */
  public static void expt01(LinearStructure<String> ls, String prefix) throws Exception {
    ReportingLinearStructure<String> expt = new ReportingLinearStructure<String>(ls, prefix);
    expt.info();
    expt.put("a");
    expt.info();
    expt.put("b");
    expt.info();
    expt.put("c");
    expt.info();
    expt.get();
    expt.info();
    expt.put("d");
    expt.info();
    expt.get();
    expt.get();
    expt.info();
    expt.put("e");
    expt.info();
    expt.clear();
    expt.put("f");
    expt.put("g");
    expt.put("h");
    expt.put("i");
    expt.put("j");
    expt.info();
    expt.clear();
  } // expt01

  public static void checkMatching(String str) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);
    ReportingLinearStructure<Character> test = new ReportingLinearStructure<Character>(null);
    char[] temp = str.toCharArray();
    for(int i = 0; i < temp.length; i++){
      if(temp[i] == '(' || temp[i] == '[' || temp[i] == '<' || temp[i] == '{'){
        test.put(temp[i]);
      }else if (temp[i] == ')' || temp[i] == ']' || temp[i] == '>' || temp[i] == '}'){
        if(test.get() != temp[i]-1){
          throw new Exception("Bracket mismatch!");
        }
      }
    }
    if(test.isEmpty()){
      pen.println("The brackets are properly closed");
    }else{
      throw new Exception("Bracket not properly closed.");
    }
  }
} // class LSExpt
