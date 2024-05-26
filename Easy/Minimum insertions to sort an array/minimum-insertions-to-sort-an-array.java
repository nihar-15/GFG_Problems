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
                    System.out.println(ob.minInsertions(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int minInsertions(int arr[], int N) 
	{ 
        //code here.
        return N - LIS(arr, N);
    } 

    int LIS(int arr[], int n) {
         int[] dp = new int[n];
        int ans = 0;
        for(int i = 0; i< n; i++){
            dp[i] = 1;
            for(int j = i-1; j >=0; j--){
                if(arr[i]>= arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    int func(int nums[], int idx, int prevIdx, int dp[][]) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx][prevIdx + 1] != -1) {
            return dp[idx][prevIdx + 1];
        }
        int a = 0, b = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            a = 1 + func(nums, idx + 1, idx, dp);
        }
        b = 0 + func(nums, idx + 1, prevIdx, dp);
        dp[idx][prevIdx + 1] = Math.max(a, b);
        return dp[idx][prevIdx + 1];
	}
}
