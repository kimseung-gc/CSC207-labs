import java.io.PrintWriter;

public class Fizzbuzz{
    public static void fizzbuzz(PrintWriter pen, int n){
        for(int i = 0; i<=n;i++){
            if(i % 3 == 0 && i % 5 == 0){
                pen.println("fizzbuzz"); 
            }
            else if(i % 3 == 0){
                pen.println("fizz"); 
            }
            else if(i % 5 == 0){
                pen.println("buzz"); 
            }
            else{
                pen.println(i);
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
        Fizzbuzz test = new Fizzbuzz();
        test.fizzbuzz(pen, 100);
    }
}
