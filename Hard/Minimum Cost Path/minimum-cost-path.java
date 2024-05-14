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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell
	
	int m , n;
	  public boolean isSafe(int[][] grid,int row,int col){
        if(row>=grid.length||row<0||col>=grid[0].length||col<0) return false;
        return true;
    }
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        m = grid.length;
        n  = grid[0].length;
       int dist[][] = new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
       int dr[] = {-1 , 0 , 1,0};
       int dc[] = {0, 1, 0, -1};
       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.dist - b.dist));
       pq.add(new Pair(0 ,0, grid[0][0]));
       dist[0][0] = grid[0][0];
       while(!pq.isEmpty()){
           Pair curr = pq.remove();
           int currow = curr.row;
           int curcol = curr.col;
           int curdist = curr.dist;
             for(int i=0;i<4;i++){
                int newr=currow+dr[i];
                int newc=curcol+dc[i];
                
                if(isSafe(grid,newr,newc)){
                    if(grid[newr][newc]+curdist<dist[newr][newc]){
                        dist[newr][newc]=grid[newr][newc]+curdist;
                        pq.add(new Pair(newr,newc,dist[newr][newc]));
                    }
       }
       
    }
       }
       return dist[n-1][m-1];
}
}

class Pair{
    int row;
    int col;
    int dist;
    
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}