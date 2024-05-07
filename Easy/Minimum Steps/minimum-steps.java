//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long p = Long.parseLong(stt.nextToken());
            long q = Long.parseLong(stt.nextToken());
            
            Solution obj = new Solution();
            System.out.println(obj.moves(n, p, q));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public long moves(long n, long p, long q)
    {
        // Your code goes here
        
        long dp[] = new long[(int)n+1];
        
        
        long ans = Long.MAX_VALUE;
        
        for(int i =1;i<=n;i++){
            long step1 = func(i , p, dp);
            long step2 = func(i , q , dp);
            dp[i] = Math.min(step1 , step2);
        }
        return dp[(int)n];
    }
    long func(long n, long p, long[] dp) {
        if (p == 1) {
            return n; // If `p` is 1, the only option is to increment by 1
        }

        long a = 1;
        long ans = Long.MAX_VALUE; // A large number to start comparison

        // Loop over powers of `p` to find possible step sizes
        while (n - a >= 0) { // Ensure `n - a` doesn't go below zero
            ans = Math.min(ans, dp[(int)(n - a)]); // Find the minimum steps to reach `n - a`
            a *= p; // Increment by the power of `p`
        }

        return ans + 1; // Add one step to the minimum found
    }
}