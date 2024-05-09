//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    int coins[] = {3, 5, 10};
    public long count(int n) {
        // Add your code here.
     
     
     long[][] dp = new long[3][n+1];
     for(long[] a: dp){
     Arrays.fill(a , -1);
     }
     return func(n ,dp, 2);
    
    }
    
    long func(int n , long dp[][] , int idx){
        if(n ==0 ){
            dp[idx][n] =1;
        }
        if(n<0 || idx < 0){
            return 0;
        }
        if(dp[idx][n] != -1){
            return dp[idx][n];
        }
        
        return dp[idx][n] = func(n- coins[idx] , dp , idx)+ func(n , dp , idx-1);
    }
}