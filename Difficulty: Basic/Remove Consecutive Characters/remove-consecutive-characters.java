//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.removeConsecutiveCharacter(S);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String removeConsecutiveCharacter(String S){
         int n = S.length();
        StringBuilder troy = new StringBuilder();

        // Iterate through the string, skipping consecutive characters
        for (int i = 0; i < n; i++) {
            // If the current character is the same as the next one, skip it
            while (i + 1 < n && S.charAt(i) == S.charAt(i + 1)) {
                i++;
            }
            // Append the current character to the StringBuilder
            troy.append(S.charAt(i));
        }
        return troy.toString();
    }
}