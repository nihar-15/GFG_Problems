//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]arr = new int[n][m];
            
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    arr[i][j] = sc.nextInt ();

    		System.out.println (new Sol().maxOnes (arr, n, m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int maxOnes (int arr[][], int N, int M)
    {
        // your code here
        
         int maxcount=0;
        int element=-1;
        for(int i=0;i<N;i++){
            int count=0;
            for(int j=0;j<M;j++){
                if(arr[i][j]==1){
                    count++;
                }
            }
            if(count>maxcount){
                maxcount=count;
                element=i;
            }
            count=0;
        }
        return element;
    }
}