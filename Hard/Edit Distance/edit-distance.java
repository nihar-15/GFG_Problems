//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String word1, String word2) {
        // Code here
         int dp[][] = new int[ word1.length()][word2.length()];
        for(int a[] : dp){
            Arrays.fill(a ,-1);
        }
    return  func(word1, word2,  word1.length()-1 , word2.length()-1,dp);
    }
      int  func(String s1 , String s2 , int i , int j , int dp[][] ){
            if(i<0){
                return j+1;
            }
            if(j < 0){
                return i +1;
            }
            if(dp[i][j] != -1){
                return dp[i][j];
            }
            if(s1.charAt(i) == s2.charAt(j)){
             return dp[i][j] = func(s1 ,s2 , i-1, j-1,dp);
            }
       return dp[i][j] = 1+ Math.min(func(s1 ,s2, i-1, j-1 ,dp),Math.min(func(s1 ,s2, i ,j-1, dp), func(s1 ,s2,i-1,j, dp)));
    
    }
}