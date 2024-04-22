//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int A[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.minRow(N, M, A));
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    int minRow(int n, int m, int arr[][]) {
        // code here
        
          
        int ans= 1;
        int max =Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int cnt =0;
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    cnt++;
                }
            }
            if(cnt!=0 && cnt>max){
                ans=i+1;
                max=cnt;
            }
        }
        return ans;
    }
};