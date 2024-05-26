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

            int[] a = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.longestSubseq(n, a);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int longestSubseq(int n, int[] a) {
        // code here
        
        int dp[][] = new int[n][n+1];
        
        for(int rows[] : dp){
            Arrays.fill(rows , -1 );
        }
        return func(a , 0 , -1  , dp);
    }
    static int func(int arr[] , int idx , int prevIdx , int dp[][]){
        if(idx == arr.length){
            return 0;
        }
        if(dp[idx][prevIdx+1] != -1){
            return dp[idx][prevIdx+1];
        }
        int a =0  , b =0;
        if(prevIdx == -1 || Math.abs(arr[idx] - arr[prevIdx])==1){
            a = 1+ func(arr , idx+1 , idx , dp);
        }
        b = func(arr , idx+1 , prevIdx , dp);
        
        return dp[idx][prevIdx+1] = Math.max(a , b);
    }
}
