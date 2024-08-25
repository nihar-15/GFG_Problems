//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
      if (s.size() == 1) {
            return s;
        }
        int element = s.pop();
       // System.out.println("Popped element: " + element);
        
        sort(s);

        Stack<Integer> arr = new Stack<>();
        while (!s.isEmpty() && s.peek() > element) {
            arr.push(s.pop());
        }

     //   System.out.println("Stack after popping elements greater than " + element + ": " + s);
       // System.out.println("Temporary stack: " + arr);

        s.push(element);
       // System.out.println("Stack after pushing element " + element + ": " + s);

        while (!arr.isEmpty()) {
            s.push(arr.pop());
        }

       // System.out.println("Final sorted stack: " + s);
        
        return s;
    }
}