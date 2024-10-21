//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0 ; i<N ; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<Integer> res = ob.increment(arr,N);
            
            for(int i=0; i<res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int carry = 0;
        if(arr.get(N-1) == 9){
            ans.add(0);
            carry = 1;
        }else{
          ans.add( arr.get(N-1) +1);   
        }
        for(int i = N - 2; i >= 0 ; i--){
            if(carry == 1){
                if(arr.get(i) == 9){
                    ans.add(0);
                    carry = 1;
                }else{
                    ans.add( arr.get(i) + 1);
                    carry = 0;
                }
            }else{
                ans.add(arr.get(i));
            }
        }
        if(carry == 1){
            ans.add(1);
        }
        Collections.reverse(ans);
        return  ans ;
    }
};