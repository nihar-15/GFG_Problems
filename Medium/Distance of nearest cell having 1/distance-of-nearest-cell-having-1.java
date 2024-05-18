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
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
int n=grid.length;
        int m=grid[0].length;
         Queue<Pair> q = new LinkedList<Pair>();
        int vis[][]= new int[n][m];
         int ans[][]= new int[n][m];
         
           for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		if(grid[i][j] ==1){
        			vis[i][j]=2;
        			q.add(new Pair(i,j,0));
        	}
        }
    }
     while(q.isEmpty()!=true){
    	   int row = q.peek().first; 
          int col = q.peek().second; 
          int t=q.peek().time;
          ans[row][col]=t;
             q.remove(); 
             
                     for(int delrow = -1; delrow<=1;delrow++) {
              for(int delcol = -1; delcol <= 1; delcol++) {
                  int nrow = row + delrow; 
                  int ncol = col + delcol; 
                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                  && isNeighbour(nrow,ncol,row,col)==true&& vis[nrow][ncol]==0 &&grid[nrow][ncol]==0){
                  	q.add(new Pair(nrow,ncol,t+1));
                  	vis[nrow][ncol]=1;
                  	
                  }
    }
}
    }
            
            
        return ans;
        
    }
    
      public static boolean isNeighbour(int nrow,int ncol,int row,int col){
            if(nrow==row-1&&ncol==col||nrow==row&&ncol==col-1||nrow==row&&ncol==col+1||nrow==row+1&&ncol==col){
                return true;
            }
            return false;
}
}


class Pair{
    int first,second,time;
  public  Pair(int f,int s,int t){
        
        this.first=f;
        this.second=s;
        this.time=t;
    }
}