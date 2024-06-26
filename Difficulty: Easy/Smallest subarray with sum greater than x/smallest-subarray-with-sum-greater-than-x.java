//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here 
        
        int minLength = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int sum = 0;

        while (j < n) {
            // Add the current element to sum
            sum += a[j];

            // While sum is greater than x, update the minimum length and subtract the starting elements
            while (sum > x) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= a[i];
                i++;
            }

            // Move the end of the window forward
            j++;
        }

        // If minLength is not updated, return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

