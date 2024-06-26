//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        
        int k = pat.length();
        int freq[] = new int[26];
        
        for(int i =0; i<pat.length();i++ ){
            freq[pat.charAt(i) -'a']++;
        }
        int ans =0;
        
        int i =0 , j =0;
        
        while(j < txt.length()){
          
            freq[txt.charAt(j)-'a']--;
            
            if(j -i + 1 == k){
                if(isAnagram(freq)){
                    ans++;
                }
                
                freq[txt.charAt(i) -'a']++;
                i++;
            }
            
            j++;
        }
        return ans;
    }
    
    boolean isAnagram(int count[]){
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}