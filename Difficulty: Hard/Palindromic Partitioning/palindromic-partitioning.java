//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
         // code here
        Boolean[][] palindrome = new Boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                isPalindrome(str, i, j, palindrome);
            }
        }
        int[] dp = new int[str.length()];
        Arrays.fill(dp, -1);
        return minCutRequired(str, str.length() - 1, dp, palindrome);
    }
    
    private static int minCutRequired(String string, int index, int[] dp, Boolean[][] palindrome) {
        if (index < 0 || palindrome[0][index]) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int cut = string.length() - 1;
        for (int i = index; i >= 0; i--) {
            if (palindrome[i][index]) {
                cut = Math.min(cut, 1 + minCutRequired(string, i - 1, dp, palindrome));
            }
        }
        dp[index] = cut;
        return cut;
    }
    
    private static boolean isPalindrome(String string, int start, int end, Boolean[][] palindrome) {
        if (start > end) {
            return true;
        }
        if (palindrome[start][end] != null) {
            return palindrome[start][end];
        }
        return palindrome[start][end] = string.charAt(start) == string.charAt(end) && 
            isPalindrome(string, start + 1, end - 1, palindrome);
    }
}
