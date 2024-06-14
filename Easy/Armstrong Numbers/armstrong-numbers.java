//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here
        
        int a = 0 , flag = n, count =0;
        int val =0;
        while(n!= 0){
            val = n%10;
            count = (val * val * val);
            a+= count;
            n = n/10;
        }
            if(a==flag){
            return "Yes";
        }
        else{
            return "No";
        }
    }
}