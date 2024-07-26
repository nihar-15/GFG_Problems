//{ Driver Code Starts
//Initial Template for Java

import java.util.*; 
import java.io.*;
import java.lang.*;

class DriverClass
{
	public static void main(String[] args) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            
            GFG g = new GFG();
            g.rotate(arr);
            printMatrix (arr);
        }
	} 
	
	static void printMatrix(int arr[][]) 
	{ 
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr[0].length; j++) 
				System.out.print(arr[i][j] + " "); 
			System.out.println(""); 
		} 
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG
{
    static void rotate(int matrix[][]) 
    {
        int n = matrix.length;
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