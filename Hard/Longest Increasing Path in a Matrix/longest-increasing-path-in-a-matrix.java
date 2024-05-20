//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.longestIncreasingPath(arr, n, m));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     int[] dr = {0, -1, 0, 1};
    int[] dc = {-1, 0, 1, 0};
    /*You are required to complete this method*/
    int longestIncreasingPath(int matrix[][], int m, int n) {
        // Code here
        
        int[][] dp = new int[m][n];
 
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }     
        int maxPathLength = 0;
        // Start DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPathLength = Math.max(maxPathLength, dfs(i, j, matrix, dp));
            }
        }
        return maxPathLength;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] dp) {
       
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        
        int maxLength = 1; 
        
        // Explore all 4 directions
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            if (isSafe(matrix, newRow, newCol) && matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength, 1 + dfs(newRow, newCol, matrix, dp));
            }
        }
        
        dp[row][col] = maxLength; 
        return maxLength;
    }

    private boolean isSafe(int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}