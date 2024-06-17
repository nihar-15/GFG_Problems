//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
          boolean[] mark = new boolean[26];
 
        //For indexing in mark[]
        int index = 0;
 
        //Convert the string to lowercase
        s = s.toLowerCase();
 
        //Iterate through all characters
        for (int i = 0; i < s.length(); i++) {
            //If it is a letter in the alphabet
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                index = s.charAt(i) - 'a';
            }
            //Mark current character
            mark[index] = true;
        }
 
        //Return false if any character is unmarked
        for (int i = 0; i <= 25; i++) {
            if (!mark[i]) {
                return false;
            }
        }
 
        //If all characters were present
        return true;
    }
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends