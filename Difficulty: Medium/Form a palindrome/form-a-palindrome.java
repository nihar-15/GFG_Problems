//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        // code here
        
        int n = str.length();
        int dp[][] = new int[n+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        String reverse = new StringBuilder(str).reverse().toString();
        int lcs = func(str , reverse , n-1 , n-1 , dp);
        return n - lcs;
    }
    static int func(String s , String t , int i , int j , int dp[][]) {
        if(i <0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 1 + func(s , t , i-1 , j-1 , dp);
        }
        
        return dp[i][j] = Math.max(func(s , t , i-1 , j, dp) , func(s , t, i , j-1 , dp));
    }
}