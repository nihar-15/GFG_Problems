//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        int dp[][] = new int[n+1][w+1];
        for(int rows[] : dp){
            Arrays.fill( rows , -1);
        }
       int result = func(cost, n, w , dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int func(int[] cost, int n, int w , int dp[][]) {
        // Base cases
        if (w == 0) return 0;
        if (n <= 0 || w < 0) return Integer.MAX_VALUE;


        if(dp[n][w] !=-1){
            return dp[n][w];
        }
        // Include current packet if available
        int include = Integer.MAX_VALUE;
        if (n <= w && cost[n-1] != -1) {
            include = cost[n-1] + func(cost, n, w - n ,dp );
        }

        // Exclude current packet
        int exclude = func(cost, n-1, w ,dp);

        return dp[n][w] = Math.min(include, exclude);
        
    }
}
