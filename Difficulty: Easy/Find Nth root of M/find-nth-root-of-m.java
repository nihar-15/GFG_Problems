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
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        int low = 1 , high = m;
        while(low <= high){
            int mid = (low+high) /2;
           // System.out.println(mid);
            int k = func(mid , n , m);
            if(k == 0){
                return mid;
            }else if(k == -1){
                low = mid  +1 ;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
    int func(int num , int n , int target){
     
        long pro = 1; 
        for(int i = 1; i <= n; i++){
            pro *= num;
            if(pro > target) return 1; // Early exit if product exceeds target
        }
        if(pro == target){
            return 0;
        } else if(pro < target){
            return -1;
        } 
        
            return 1;
        
    }
}