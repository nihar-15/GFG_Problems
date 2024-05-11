//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ob.gfSeries(N);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long findGF(long N){
        // code here
        if(N==1 || N==2){
            return N-1;
        }
       return (long)  ( Math.pow(findGF(N-2),2) - findGF(N-1));
      // return ans;
    }
    
    static void gfSeries(int N){
        for(int i = 1 ;i<=N; i++){
            System.out.print(findGF(i)+ " ");
        }
        System.out.println();
    }
}

