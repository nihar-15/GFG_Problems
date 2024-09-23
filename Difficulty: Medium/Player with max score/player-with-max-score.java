//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            

            Solution ob = new Solution();
            if(ob.is1winner(N,arr))
            System.out.println("1");
            else
            System.out.println("0");
            
        }
    }
}

// } Driver Code Ends


class Solution{

    static Boolean is1winner(int n , int nums[]){
     int sum =0 ;
     int dp[][] = new int[n+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
       
        for(int num : nums){
            sum += num ;
        }
        int player1 = func(nums , 0 , n-1 , dp);
        int player2 = sum - player1;
        return player1 >= player2;
    }
   static    int func(int nums[] , int i , int j , int dp[][]){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == j){
            return nums[i];
        }
        int takeIth = nums[i] + Math.min(func(nums , i+2 ,j , dp) , func(nums , i +1 , j-1, dp));
        int takeJth = nums[j] + Math.min(func(nums , i , j -2, dp ) , func(nums , i+1  , j -1, dp));
        return dp[i][j] = Math.max( takeIth , takeJth);
    }
}