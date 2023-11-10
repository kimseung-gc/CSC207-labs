package Class8.taojava.labs.polymorphism;

import java.io.PrintWriter;
import org.w3c.dom.Text;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of September 2014
 */
public class TBExpt
{
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static TextBlock centered(String par, int maxLen){
    String[] num = par.split("\n");
    int max = 0;
    for(int i = 0; i < num.length; i++){
      if(max < num[i].length()){
        max = num[i].length();
      }
    }
    String resultantBox = "+" + TBUtils.dashes(maxLen) + "+" + "\n";
    for(int i = 0; i < num.length; i++){
      resultantBox += "|" + TBUtils.spaces((int)((maxLen-par.length())/2)) + num[i] + TBUtils.spaces((int)((maxLen-par.length())/2)) + "|" + "\n";
    }
    resultantBox += "+" + TBUtils.dashes(maxLen) + "+";
    return new TextLine(resultantBox);
  }

  public static TextBlock upperLowerBoundaries(String par){
    String[] num = par.split("\n");
    int max = 0;
    for(int i = 0; i < num.length; i++){
      if(max < num[i].length()){
        max = num[i].length();
      }
    }
    String resultantBox = "+" + TBUtils.dashes(max) + "+" + "\n";
    for(int i = 0; i < num.length; i++){
      resultantBox += "|" + num[i] + TBUtils.spaces(max-par.length()) + "|" + "\n";
    }
    resultantBox += "+" + TBUtils.dashes(max) + "+";
    return new TextLine(resultantBox);
  }

  public static TextBlock upperBoundaries(String par){
    String[] num = par.split("\n");
    int max = 0;
    for(int i = 0; i < num.length; i++){
      if(max < num[i].length()){
        max = num[i].length();
      }
    }
    String resultantBox = "+" + TBUtils.dashes(max) + "+" + "\n";
    for(int i = 0; i < num.length; i++){
      if(i == num.length - 1){
        resultantBox += "|" + num[i] + TBUtils.spaces(max-par.length()) + "|";
      }else{
        resultantBox += "|" + num[i] + TBUtils.spaces(max-par.length()) + "|" + "\n";
      }
    }
    return new TextLine(resultantBox);
  }

  public static TextBlock lowerBoundaries(String par){
    String[] num = par.split("\n");
    int max = 0;
    for(int i = 0; i < num.length; i++){
      if(max < num[i].length()){
        max = num[i].length();
      }
    }
    String resultantBox = "";
    for(int i = 0; i < num.length; i++){
      resultantBox += "|" + num[i] + TBUtils.spaces(max-par.length()) + "|" + "\n";
    }
    resultantBox += "+" + TBUtils.dashes(max) + "+";
    return new TextLine(resultantBox);
  }

  public static void main(String[] args)
    throws Exception
  {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello World!");
    
    // Print out the block
    TBUtils.print(pen, block);

    TextBlock block2 = new TextLine("+" + TBUtils.dashes(12) + "+" + "\n" + "|" + "Hello World!" + "|" + "\n" + "+" + TBUtils.dashes(12) + "+");
    
    TBUtils.print(pen, block2);

    TBUtils.print(pen, centered("NINE", 10));

    VComposition vcomp1 = new VComposition(upperBoundaries("Hello  "), lowerBoundaries("Goodbye"));
    for(int i = 0; i < vcomp1.height(); i++){
      pen.println(vcomp1.row(i));
    }

    VComposition vcomp = new VComposition(upperLowerBoundaries("Hello"), upperLowerBoundaries("GoodBye"));
    for(int i = 0; i < vcomp.height(); i++){
      pen.println(vcomp.row(i));
    }

    HComposition hcomp = new HComposition(upperLowerBoundaries("Hello"), new TextLine("Goodbye"));
    for(int i = 0; i < hcomp.height(); i++){
      pen.println(hcomp.row(i));
    }
    
    HComposition hcomp1 = new HComposition(new TextLine("Goodbye"), upperLowerBoundaries("Hello"));
    for(int i = 0; i < hcomp1.height(); i++){
      pen.println(hcomp1.row(i));
    }
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
