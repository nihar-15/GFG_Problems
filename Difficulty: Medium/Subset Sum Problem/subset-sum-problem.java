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
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        int dp[][] = new int[sum][N];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        return func(0 ,arr , sum , 0 , dp);
    }
    
    static boolean func(int i , int arr[] , int sum , int currentSum  , int dp[][]){
        
        if( i == arr.length){
            return currentSum == sum;
        }
        if(sum == currentSum){
            return true;
        }
        if(dp[currentSum][i] != -1){
            return dp[currentSum][i] == 0;
        }
        boolean take = false;
        if(arr[i] + currentSum <= sum){
            take = func(i+1 , arr , sum ,arr[i] + currentSum, dp );
        }
        boolean notTake = func(i +1 , arr , sum , currentSum, dp);
        boolean a = notTake || take;
        if(a == true){
             dp[currentSum][i] = 0;
             return true;
        }
         dp[currentSum][i] =  1 ;
           return false;
    }
}    