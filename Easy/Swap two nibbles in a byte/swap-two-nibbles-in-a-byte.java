//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int swapNibbles(int n) {
        // code here
                int ans = 0;
        for(int i = 0; i < 8; i++) {
            if((n&1) == 1) {
                if(i < 4)
                    ans = ans + (1 << (4 + i));
                else 
                    ans = ans + (1 << (i - 4));
            }
            n = n >> 1;
        }
        return ans;

    }
}