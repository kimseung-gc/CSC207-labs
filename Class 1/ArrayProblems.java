import java.io.PrintWriter;

public class ArrayProblems{
    //1
    public static int max(int[] arr){
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++){
            if (arr[i] > temp){
                temp = arr[i];
            }
        }
        return temp;
    }
    public static int min(int[] arr){
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++){
            if (arr[i] < temp){
                temp = arr[i];
            }
        }
        return temp;
    }
    //2
    public static int range(int[] arr){
        return max(arr)-min(arr);
    }
    //3
    public static int[] rev(int[] arr){
        int[] temp = new int[arr.length];
        int j = 0;
        for(int i = arr.length-1; i>=0; i--){
            temp[j] = arr[i];
            j++;
        }
        return temp;
    }
    //4
    public static int longestIncreasingSubsequence(int[] arr){
        int count = 1;
        int tempReturn = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i-1] < arr[i]){
                count++;
            }else{
                if(tempReturn < count){
                    tempReturn = count;
                }
                count = 1;
            }
        }
        return tempReturn;
    }
    //5
    public static int[] memofib(int n){
        int count1 = 1;
        int count2 = 1;
        int[] temp = new int[n];
        for(int i = 0; i < n;i++){
            if(i == 0 || i == 1){
                temp[i] = count1;
            }
            else{
                temp[i] = temp[i-1]+temp[i-2];
            }
        }
        return temp;
    }
    /* Recursion requires much more memory usage, while array declaration itself
     * takes as much space, so the recursion approach is memory inefficient in
     * this case.
     */
    public static void main(String[] args) throws Exception{
        java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
        //1
        int[] arr = {3, 7, -10, 2, 9, 1};
        pen.println(max(arr));
        pen.println(min(arr));
        //2
        pen.println(range(arr));
        //3
        for(int i = 0; i<arr.length; i++){
            pen.print(rev(arr)[i]);
            pen.print(" ");
        }
        pen.println("");
        //4
        int[] arr2 = {3, 7, -10, 2, 8, 9, 5, 1};
        pen.println(longestIncreasingSubsequence(arr));
        pen.println(longestIncreasingSubsequence(arr2));
        //5
        int[] tempArr = memofib(10);
        for(int i = 0; i<tempArr.length; i++){
            pen.print(tempArr[i]);
            pen.print(" ");
        }
        pen.println("");
    }
}
