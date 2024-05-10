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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
       List<String> ans = new ArrayList<>();
        boolean[] freq = new boolean[S.length()];
        findPermutations(S, "", ans, freq);
        Collections.sort(ans); // Sort the output to match the expected order
        return ans;
    }

    private void findPermutations(String str, String current, List<String> ans, boolean[] freq) {
        if (current.length() == str.length()) {
            if (!ans.contains(current)) { // Ensure unique entries
                ans.add(current);
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!freq[i]) {
                freq[i] = true; // Mark the character as used
                findPermutations(str, current + str.charAt(i), ans, freq); // Recursive call
                freq[i] = false; // Unmark for backtracking
            }
        }
    }
}