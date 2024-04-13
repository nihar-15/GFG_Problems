//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {
        // code here\
          long reversed = 0;
        int numberOfBits = 32; // Assuming 64-bit long integer
        
        for (int i = 0; i < numberOfBits; i++) {
            // Shift the current bits in reversed to the left by 1 position
            reversed <<= 1;
            // Extract the least significant bit from x and append it to reversed
            reversed |= (x & 1);
            // Shift bits of x to the right by 1 position
            x >>= 1;
        }
        
        return reversed;
    }
};