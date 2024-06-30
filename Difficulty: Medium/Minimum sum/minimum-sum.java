//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            String ans = new Solution().solve(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java





class Solution {
    String solve(int[] arr, int n) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }

        return removeLeadingZeros(addStrings(num1.toString(), num2.toString()));
    }

    private String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int y = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
     private String removeLeadingZeros(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        return i == str.length() ? "0" : str.substring(i);
    }

}

