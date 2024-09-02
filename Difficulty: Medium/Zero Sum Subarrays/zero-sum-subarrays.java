//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        int count=0;
       Map<Integer, Integer> map = new HashMap<>();
       int sum =0 ;
       map.put(sum , 1);
       for(int i = 0; i< n ; i++){
           sum += arr[i];
           if(map.containsKey(sum)){
              count += map.get(sum);
              map.put(sum , map.get(sum)+1);
           }else{
               map.put(sum , 1);
           }
       }
       return count;
    }
}