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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxCalories(Arr,n));
                }
        }
}    
// } Driver Code Ends




class Solution
{
	public int maxCalories(int arr[], int n)
	{
	    
	    int dp[][] = new int[n][3];
	    for(int a[] : dp){
	        Arrays.fill(a , -1);
	    }
		// Your code goes here
		return func(arr , 0 , 0 , dp);
	}
	int func(int arr[] , int idx , int count , int dp[][] ){
	    if(idx >= arr.length){
	        return 0;
	    }
	    if(dp[idx][count] !=-1){
	        return dp[idx][count] ;
	    }
	    int a = 0;
	    if(count < 2){
	        a =  arr[idx] + func(arr , idx+1 , count +1  ,dp);
	    }
	    int b = func(arr , idx+1 ,0 ,dp);
	    
	    return dp[idx][count] = Math.max(a, b);
	}
}