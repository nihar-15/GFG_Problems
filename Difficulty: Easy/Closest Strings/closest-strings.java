//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            ArrayList<String> arr = new ArrayList<String>();
            String input[] = read.readLine().split(" ");
            
            for(int i = 0; i < n; i++){
                arr.add(input[i]);
            }
            String word1 = read.readLine();
            String word2 = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(arr,word1,word2));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int shortestDistance(ArrayList<String> s, String word1, String word2) {
        // code here
        int firstIndex =-1;
        int secondIndex = -1;
        int ans = 100000;
        for(int i =0;i<s.size();i++){
            if(word1.equals(s.get(i))){
                firstIndex = i;
            }
           if(word2.equals(s.get(i))){
                secondIndex = i;

            } 
            if(firstIndex !=-1 && secondIndex != -1){
                ans = Math.min(ans , Math.abs(firstIndex - secondIndex));
            }
        }
       return ans;
    }
};