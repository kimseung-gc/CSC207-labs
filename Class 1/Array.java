import java.io.PrintWriter;

public class Array{
    
    public static void main(String[] args) throws Exception{
        java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
        int[] arr = new int[5];
        arr[6] = 1;
        pen.println(arr[6]);
    }
}
/* (Initialization): The int arr[5] throws an error saying "Array.java:7: error: ']' expected." When we declare int[5] arr, it throws an error that the line is not a statement.
 * (New Expressions): When we run the following code snippet
        int[] arr = new int[5];
        for(int i = 0; i<5; i++){
            pen.println(arr[i]);
        }
   , the variables are initialized as 0.
 * (Out of bounds): When we try to print the element over the bounds, it throws an error saying that it is out of bounds.
 */
