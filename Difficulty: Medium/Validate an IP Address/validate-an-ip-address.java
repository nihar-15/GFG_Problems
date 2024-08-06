//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
        String []octets = str.split("\\.");
        if(octets.length != 4){
            return false;
        }
        for(String s : octets){
            if(s.equals("")){
                return false;
            }
            
            int o = Integer.parseInt(s);
            if(o < 0  || o > 255 ){
                return false;
            }
        }
        
        return true;
    }
}