//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length ;
        Stack<Integer> stack = new Stack<>();
        int leftNearest[] = new int[n];
        int rightNearest[] = new int[n];
        int ans = 0;
        for(int i =0 ; i< n ;i++){
            if(stack.isEmpty()){
                leftNearest[i] = 0;
            }else{
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                     leftNearest[i] = 0;
                }else{
                     leftNearest[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        
        while(!stack.isEmpty()){
            stack.pop();
        }
        for(int i = n -1 ; i>= 0 ; i--){
            if(stack.isEmpty()){
                rightNearest[i] = 0;
            }else{
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    rightNearest[i] = 0;
                }else{
                     rightNearest[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        for(int i =0 ; i< n ;i++){
            ans = Math.max(ans , Math.abs(rightNearest[i] - leftNearest[i]));
        }
        return ans;
    }
    
}
