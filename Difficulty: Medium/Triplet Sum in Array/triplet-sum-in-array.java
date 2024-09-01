//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int X = Integer.parseInt(inputLine[1]);
            int A[] = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.find3Numbers(A, n, X);
            System.out.println(ans ? 1 : 0);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Should return true if there is a triplet with sum equal
    // to x in arr[], otherwise false
    public static boolean find3Numbers(int arr[], int n, int x) {
HashSet<Integer> hs=new HashSet<>();

        for(int i=0;i<n;i++)

        {

            hs.add(arr[i]);

        }

 

        

        for(int i=0;i<n;i++)

        {

            for(int j=i+1;j<n;j++)

            {

              int f=x-arr[i]-arr[j];

              if(f<x && f!=arr[i] && f!=arr[j] && hs.contains(f))

              {

                  return true;

              }

            }

        }

        return false;
    }
}
