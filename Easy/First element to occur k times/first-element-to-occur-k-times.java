//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class GfG { 
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    int[] arr = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++)arr[i] = Integer.parseInt(inputLine[i]);
		    
		    Solution obj = new Solution();
		    System.out.println(obj.firstElementKTime(n, k, arr));
		}
	}
}

// } Driver Code Ends


class Solution
{
    public int firstElementKTime(int n, int k, int[] a) { 
        
        int occurences[] = new int[201];
        int i=0;
        for( ;i< n; i++){
            occurences[a[i]]++;
            if(occurences[a[i]]== k){
                return a[i];
            }
        }
        
        int ans =-1;
        
        for(i =0;i<n;i++){
            if(occurences[a[i]]==k){
                return a[i];
            }
        }
        return -1;
    } 
}