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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    
	    return fun3(coins,V)
;	} 
	
	
    static int fun3(int d[],int sum){
        int n=d.length;
        int dp[][]=new int[n][sum+1];
        
        for(int a[]:dp){
            Arrays.fill(a, -1);
        }
        
        for(int i=0;i<=sum;i++){
            if(i%d[0]==0){
                dp[0][i]=i/d[0];
            }else{
                 dp[0][i]=(int) 1e9;
            } 
        }
        
        for(int ind=1;ind<n;ind++){
            for(int target=0;target<=sum;target++){
                int notTaken=0+dp[ind-1][target];
                int taken =Integer.MAX_VALUE;
                if(d[ind]<=target){
                    taken =1+dp[ind][target-d[ind]];
                }
                
                dp[ind][target]=Math.min(taken,notTaken);
            }
        }
         int ans = dp[n - 1][sum];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}