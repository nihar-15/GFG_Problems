//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
       
  String[] arr = str.split("\\.");
        
        // If the array has only one word or is empty, return the original string.
        if (arr.length == 0 || arr.length == 1) {
            return str;
        }

        // Reverse the words.
        String ans = "";
        for (int i = arr.length - 1; i > 0; i--) {
            ans += arr[i] + ".";
        }
        ans += arr[0]; // Append the first word (without an extra dot at the end).

        return ans;
    }
}