//{ Driver Code Starts
//Initial Template for Java

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
            String[] S = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            obj.swapElements(arr, n);
            for(int i = 0; i < n; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void swapElements(int[] arr, int n)
    {
        // Code here
        
        for(int i =0;i<n-1;i++){
            swap(arr , i);
        }
    }
    
     public void swap(int arr[] , int i ){
         int j = i+2;
         if(j>=arr.length){
             return ;
         }
         int temp = arr[i];
         arr[i]= arr[j];
         arr[j] = temp;
     }
}