//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A, B));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRepeats(String s1, String s2) {
        // code here
         for (char c : s2.toCharArray()) {
        if (!s1.contains(String.valueOf(c))) {
            return -1;
        }
    }

    int count = 1;
    StringBuilder str = new StringBuilder(s1);
    
    // Repeat s1 until its length is at least the length of s2
    while (str.length() < s2.length()) {
        str.append(s1);
        count++;
    }

    // Check if s2 is now a substring
    if (str.toString().contains(s2)) {
        return count;
    }

    // Append one more time as a final check
    str.append(s1);
    count++;
    
    return str.toString().contains(s2) ? count : -1;
    }
};