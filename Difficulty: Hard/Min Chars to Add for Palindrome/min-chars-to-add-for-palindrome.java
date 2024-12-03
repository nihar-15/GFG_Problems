//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public static int minChar(String A) {
        // Write your code here
        
           String rev = new StringBuilder(A).reverse().toString();
        String concat = A + "$" + rev;
        int[] lps = new int[concat.length()];
        int y = 0;
        for (int x = 1; x < concat.length(); x++) {
            while (y > 0 && concat.charAt(x) != concat.charAt(y)) {
                y = lps[y - 1];
            }
            if (concat.charAt(x) == concat.charAt(y)) {
                y++;
            }
            lps[x] = y;
        }
        return A.length() - lps[concat.length() - 1];
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }
    }
}
// } Driver Code Ends