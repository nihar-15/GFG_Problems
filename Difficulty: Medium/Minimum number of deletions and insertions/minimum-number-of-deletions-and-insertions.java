//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends




//User function Template for Java

class Solution
{
	public int minOperations(String word1, String word2) 
	{ 
	    // Your code goes here
	    
	     int lcsLength = lcs(word1 , word2);
        return (word1.length()-lcsLength) + (word2.length() - lcsLength);
    }
    public int lcs(String text1 , String text2){
          int n = text1.length();
     int m = text2.length();
     int dp[][] = new int[n][m];
     for(int a[] :dp){
        Arrays.fill(a , -1);
     }
    return  func(text1 , text2 , n-1, m-1, dp);

        }
    int func(String text1 , String text2, int n , int m, int dp[][]){
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