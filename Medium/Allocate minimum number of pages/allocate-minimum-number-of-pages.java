//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        
        int sum=0, mini=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            sum += A[i];
            mini = Math.max(mini, A[i]);
        }
        
        return fun(A,mini, sum ,M);
    }
    
    public static int  fun(int arr[] ,int low , int high,int M){
        int N = arr.length;
        if(M>N){
            return -1;
        }
        while( low<= high){
            int mid = low+ (high - low)/2;
            if(canAllocate(arr, mid) > M){
                 low= mid+1;
              
            }else{
               high = mid -1;
            }
            
        }
        
        return low;
        
    }
    
    
    
    public  static int canAllocate(int arr[] , int pages ){
        
        int k = 1;
        int sum =0;
        for(int i =0;i<arr.length;i++){
            if(sum+arr[i] <= pages){
                sum += arr[i];
            }else{
                k++;
                sum= arr[i];
            }
        }
        
        return k;
        
    }
    
    
};