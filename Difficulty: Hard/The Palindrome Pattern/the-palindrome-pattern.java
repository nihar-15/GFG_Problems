//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        // Code here
        int n = arr.length;
        int m = arr[0].length;
        
        for(int i =0;i < n ;i++){
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            for (int j =0;j <m;j++){
                s1.append(arr[i][j]);
            }
            if (s1.toString().equals(s1.reverse().toString())){
                String  ans = i+" "+"R";
                return ans;
            }
        }
           for(int i=0;i<m;i++)
        {
            StringBuilder s1=new StringBuilder();
            StringBuilder s2=new StringBuilder();
            for(int j=0;j<n;j++)
            {
                s1.append(arr[j][i]);
                 s2.append(arr[j][i]);
            }
            String str1=s1.reverse().toString();
             String str2=s2.toString();
             
            if(str1.equals(str2))
            {
                String ans= i + " " +"C";
                return ans;
            }
            
        }
        
        return "-1";
        
    }
    
    
}
