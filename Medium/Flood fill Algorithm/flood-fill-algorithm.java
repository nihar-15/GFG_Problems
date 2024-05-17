//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
                          int n = image.length; 
        int m = image[0].length; 
        int[][] ans = image;
      int old=image[sr][sc];
      dfs(sr,sc,ans,image,old,newColor);
      return ans;
    
    }
    
        private static void dfs(int ro, int co, int[][] ans, int[][] grid,int old,int newColor) {
      ans[ro][co] = newColor; 
      
      int m = grid.length; 
      int n= grid[0].length; 
      for(int i=-1;i<=1;i++){
      	for(int j=-1;j<=1;j++){
      		int nr=ro+i;
      		int nc=co+j;
      		if(isNeighbour(nr,nc,ro,co)==true && nr>=0 && nr<m && nc>=0&& nc<n && grid[nr][nc]==old && ans[nr][nc] != newColor){
      			dfs(nr,nc,ans,grid,old,newColor);
      		}
      	}
      }
      return;
 
        }
        
        public static boolean isNeighbour(int nrow,int ncol,int row,int col){
            if(nrow==row-1&&ncol==col||nrow==row&&ncol==col-1||nrow==row&&ncol==col+1||nrow==row+1&&ncol==col){
                return true;
            }
            return false;
    }
}