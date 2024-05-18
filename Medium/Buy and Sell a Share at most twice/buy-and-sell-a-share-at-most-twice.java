//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] prices) {
        // code here
          int dp[][][] = new int[2][3][prices.length];
        for(int [][]d: dp){
            for(int a[] : d){
            Arrays.fill( a , -1);
        }
        }
      return func(prices , 0, 1 , 2, dp);
    }
   static  int func(int prices[] , int day , int canBuy,  int capacity , int dp[][][]){
       if(capacity <=0 || day >= prices.length){
        return 0;
       }
       if(dp[canBuy][capacity][day] != -1 ){
         return dp[canBuy][capacity][day] ;
       }
       if(canBuy == 1 ){
        return dp[canBuy][capacity][day] =  Math.max(-prices[day]+func(prices, day+1, 0 , capacity , dp), func(prices, day+1, 1, capacity ,dp));
       }
       return dp[canBuy][capacity][day] = Math.max( prices[day]+func(prices, day+1, 1, capacity-1 ,dp) , func(prices, day+1 ,0 , capacity ,dp));
    }
    
}
        
