//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDeletions(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java
class Solution
{
	public int minDeletions(int arr[], int n) 
	{ 
	   //code here.
	   
	   int lis[]=new int[n];
        lis[0]=1;
        
        for(int i=1;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                }
            }
            
        }
        int res=lis[0];
        for(int i=1;i<n;i++){
            res=Math.max(res,lis[i]);
        }
        return n-res;
    }
}