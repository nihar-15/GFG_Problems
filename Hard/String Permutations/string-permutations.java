//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
         ArrayList<String> ans = new ArrayList<>();
        boolean[] freq = new boolean[S.length()];
        findPermutations(S, "", ans, freq);
        Collections.sort(ans); // Sort the output to match the expected order
        return ans;
    }

    private void findPermutations(String str, String current, ArrayList<String> ans, boolean[] freq) {
        if (current.length() == str.length()) {
       
                ans.add(current);
            
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
