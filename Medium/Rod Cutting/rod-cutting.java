//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int arr[] =new int[n+1];
        Arrays.fill(arr, -1);
        return recur(price,n,arr);
        
    }
    public int recur(int[] p,int n, int arr[]){
        if(n<=0){
            return 0;
        }
        int ans=Integer.MIN_VALUE;
        if(arr[n]!= -1){
            return arr[n];
        }
        for(int i=1;i<=n;i++){
            int a=recur(p,n-i,arr);
            a=a+p[i-1];
            ans=Math.max(ans,a);
        }
        return arr[n]=ans;
            
    }
}