import java.io.PrintWriter;

/*1.
 *   1. It was throwing "Class names, 'HelloWorld.c', are only accepted if annotation processing is explicitly requested."
 *   2. File not found error thrown
 *   3. They recognize HelloWorld.class itself as a file name, so it throws an error of "ClassNotFoundException."
 *   4. The program is case sensitive, so throws an error when main is named "Main." When new lines are put, it does not really throw an error unless the process name is split.
 *   5. When any other parts except for "throws Exception" is modified, it will throw an error stating that we must write main in the format: "public static void main(String[] args)."
 *   6. Expects class decorations in order for an object to be declared.
 *   7. Expects static to be present when a function is declared inside the public class HelloWorld.
 */
public class HelloWorld{
    public static int process(int num){
        return 2*num;
    }
    public static void main(String[] args) throws Exception{
        int num = 15;
        java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
        pen.println("Hello World!");
        int num2 = process(num);
        pen.println(num2);
    }
}
