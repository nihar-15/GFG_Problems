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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
  static int MOD = 1000000007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	  int dp[][] = new int[n+1][sum+1];
	  for(int d[] : dp){
	      Arrays.fill(d , -1);
	  }
	  return func(arr, 0 , sum , 0 , dp);
	} 
	int func(int arr[] , int i , int sum , int currentSum , int dp[][]){
	    
	    if(i == arr.length){
	        if(sum == currentSum){
	            return 1;
	        }
	        return 0;
	    }
	    if(dp[i][currentSum] != -1){
	        return dp[i][currentSum];
	    }
	    int take = 0;
	    if(currentSum + arr[i] <= sum){
	        take = func(arr , i+1 , sum , currentSum + arr[i] , dp) %MOD;
	    }
	    int notTake = func(arr , i+1 , sum , currentSum , dp) % MOD;
	    
	    return dp[i][currentSum] = (take + notTake)%MOD;
	}
}