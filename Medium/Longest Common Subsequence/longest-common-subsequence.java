//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int n = s1.length();
        int m = s2.length();
          int dp[][] = new int[n][m];
     for(int a[] :dp){
        Arrays.fill(a , -1);
     }
    return  func(s1 , s2 , n-1, m-1, dp);

        }
      static  int func(String text1 , String text2, int n , int m, int dp[][]){
            if(n <0 || m<0){
                return 0;
            }
            if(dp[n][m] != -1){
                return dp[n][m];
            }
            if(text1.charAt(n) == text2.charAt(m)){
                return dp[n][m] = 1+ func(text1 , text2 , n-1 , m-1 , dp);
            }
            return dp[n][m]= 0 + Math.max(func(text1 , text2 ,n-1 , m ,dp) , func(text1 , text2 , n , m-1 , dp));
        }
    
    
}