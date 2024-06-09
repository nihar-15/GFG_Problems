//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        
        int[] count = new int[26]; // To store count of characters
        Queue<Character> q = new LinkedList<>(); // To store characters in order of their appearance
        StringBuilder ans = new StringBuilder(); // To build the result string

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            count[c - 'a']++;
            q.offer(c);

            // Remove characters from the front of the queue if they are repeating
            while (!q.isEmpty() && count[q.peek() - 'a'] > 1) {
                q.poll();
            }

            // Append the current first non-repeating character or '#' if no such character exists
            if (q.isEmpty()) {
                ans.append('#');
            } else {
                ans.append(q.peek());
            }
        }

        return ans.toString();
    }
}