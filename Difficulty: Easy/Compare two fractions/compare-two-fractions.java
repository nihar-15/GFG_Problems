//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code 
          String[] fractions = str.split(",");
        String[] firstFractionParts = fractions[0].trim().split("/");
        double firstNumerator = Double.parseDouble(firstFractionParts[0].trim());
        double firstDenominator = Double.parseDouble(firstFractionParts[1].trim());
        double firstValue = firstNumerator / firstDenominator;
        String[] secondFractionParts = fractions[1].trim().split("/");
        double secondNumerator = Double.parseDouble(secondFractionParts[0].trim());
        double secondDenominator = Double.parseDouble(secondFractionParts[1].trim());
        double secondValue = secondNumerator / secondDenominator;
        if (firstValue > secondValue) {
            return fractions[0].trim();
        } else if (secondValue > firstValue) {
            return fractions[1].trim();
        } else {
            return "equal";
        }
    }
}
