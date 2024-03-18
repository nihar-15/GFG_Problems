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
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.sortedCount(N, M, Mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int sortedCount(int r, int c, int mat[][]) {
        // code here
        
          int result = 0; // Initialize result
 
        // Start from left side of matrix to
        // count increasing order rows
        for (int i = 0; i < r; i++) {
             
            // Check if there is any pair of element
            // that are not in increasing order.
            int j;
            for (j = 0; j < c - 1; j++)
                if (mat[i][j + 1] <= mat[i][j])
                    break;
 
            // If the loop didn't break (All elements
            // of current row were in increasing order)
            if (j == c - 1)
                result++;
        }
 
        // Start from right side of matrix to
        // count increasing order rows ( reference
        // to left these are in decreasing order )
        for (int i = 0; i < r; i++) {
             
            // Check if there is any pair of element
            // that are not in decreasing order.
            int j;
            for (j = c - 1; j > 0; j--)
                if (mat[i][j - 1] <= mat[i][j])
                    break;
 
            // Note c > 1 condition is required to make
            // sure that a single column row is not counted
            // twice (Note that a single column row is sorted
            // both in increasing and decreasing order)
            if (c > 1 && j == 0)
                result++;
        }
        return result;
    }
};