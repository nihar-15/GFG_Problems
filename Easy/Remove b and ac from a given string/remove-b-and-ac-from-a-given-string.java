//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            
            System.out.println(ob.stringFilter(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String stringFilter(String input) 
    {
        // Your code goes here
     char[] charArray = input.toCharArray();
        
        int index = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'b') {
                // Skip 'b'
                continue;
            } else if (charArray[i] == 'a' && i < charArray.length - 1 && charArray[i+1] == 'c') {
                // Skip 'a' and 'c' (eliminate "ac")
                i++;
                continue;
            } else {
                // Otherwise, keep the character
                charArray[index++] = charArray[i];
            }
        }

        // Convert charArray back to String
        return new String(charArray, 0, index);
        
    }
    
}