//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine();
            String[] S = s.split(" ");
            long x = Long.parseLong(S[0]);
            long n = Long.parseLong(S[1]);
            long m = Long.parseLong(S[2]);
            Solution ob = new Solution();
            long ans = ob.PowMod(x, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long PowMod(long A, long B, long C)
    {
        // Code here
        
        // Base cases 
    if (A == 0) 
        return 0; 
    if (B == 0) 
        return 1; 
     
    // If B is even 
    long y; 
    if (B % 2 == 0)
    { 
        y = PowMod(A, B / 2, C); 
        y = (y * y) % C; 
    } 
     
    // If B is odd 
    else
    { 
        y = A % C; 
        y = (y * PowMod(A, B - 1, 
                             C) % C) % C; 
    } 
     
    return ((y + C) % C); 
    }
}