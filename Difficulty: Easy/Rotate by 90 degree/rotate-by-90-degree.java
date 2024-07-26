//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int matrix[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(st[k++]);
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix, n);
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][], int n) 
    { 
        transpose(n , matrix);
        reverse(matrix);
    }
     static void transpose(int n,int a[][])
    {
        for(int i =0 ; i < n; i++){
            for(int j = i+1 ; j< n ; j++){
               int   temp = a[i][j];
               a[i][j] = a[j][i];
               a[j][i] = temp;
            }
        }
    }
        static void reverse(int matrix[][]){
            for(int i =0; i<matrix.length ; i++){
                int start =0 , end = matrix.length -1;
                
                while(start < end){
                    int temp = matrix[start][i];
                    matrix[start][i] = matrix[end][i];
                    matrix[end][i] = temp ;
                    start++;
                    end--;
                }
            }
        }
}