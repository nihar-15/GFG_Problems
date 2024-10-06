//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    int m , n;
    public int numIslands(char[][] grid) {
        // Code here
     m = grid.length;
        n = grid[0].length;
        int[][] vis = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0' && vis[i][j] != 1) {
                    dfsIterative(grid, i, j, vis);
                    count++;
                }
            }
        }

        return count;
    }

    void dfsIterative(char[][] grid, int row, int col, int[][] vis) {
        int[] rowDir = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] colDir = {0, 1, 1, 1, 0, -1, -1, -1};
        Stack<int[]> stack = new Stack<>();
        
        stack.push(new int[]{row, col});
        vis[row][col] = 1;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int currRow = current[0];
            int currCol = current[1];

            for (int i = 0; i < 8; i++) {
                int newRow = currRow + rowDir[i];
                int newCol = currCol + colDir[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] != '0' && vis[newRow][newCol] != 1) {
                    vis[newRow][newCol] = 1;
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
        
    }
}