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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
          int n=mat.length,m=mat[0].length,row=0,col=0;
       int[] result=new int[n*m];
       for(int i=0;i<result.length;i++){
           result[i]=mat[row][col];
           if((row+col)%2==0){
               if(col==n-1){
                   row++;
               }else if(row==0){
                   col++;
               }else{
                   row--;
                   col++;
               }
           }else{
               if(row==m-1){
                   col++;
               }else if(col==0){
                   row++;
               }else{
                   row++;
                   col--;
               }
           }
       }
       return result;
    }
}