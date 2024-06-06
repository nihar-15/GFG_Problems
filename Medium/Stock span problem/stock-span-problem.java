//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int temperatures[], int n) {
       int ans[] = new  int[temperatures.length];
         Stack<Pair> stack = new Stack<>();
           for(int i =0;i<temperatures.length;i++){
            int span =1;
         int temp= temperatures[i];
        while(!stack.isEmpty() &&  temp >= stack.peek().price){
            span += stack.pop().span;
        }
        stack.push(new Pair(temp , span));
          ans[i]= stack.peek().span; 

           }

return ans;

    }
}

class Pair {
    int price;
    int span;

    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}


//{ Driver Code Starts.

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            int i = 0;
            for (i = 0; i < n; i++) a[i] = sc.nextInt();

            int[] s = new Solution().calculateSpan(a, n);

            for (i = 0; i < n; i++) {
                System.out.print(s[i] + " ");
            }

            System.out.println();
        }
    }
}
// } Driver Code Ends