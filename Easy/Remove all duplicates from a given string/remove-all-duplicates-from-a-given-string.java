//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    String removeDuplicates(String str) {
        
        
        int charFreq[]= new int[128];
        String ans="";
        for(int i=0;i<str.length();i++){
            if(charFreq[str.charAt(i)]==1){
                continue;
            }else{
                charFreq[str.charAt(i)]++;
                ans+=str.charAt(i);
            }
        }
        
   return ans;
    }
}

