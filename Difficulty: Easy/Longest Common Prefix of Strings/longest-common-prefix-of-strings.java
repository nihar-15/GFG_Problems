//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        if(arr.length == 1){
            return arr[0];
        }
        String smallestString = arr[0];
        int len = Integer.MAX_VALUE;
        for( String s : arr){
            if(s.length() < len){
                smallestString = s;
                len = s.length();
            }
        }
        int ans = -1;
        for(int i = 1 ; i<= len; i++){
            int cnt =0;
            for(String str : arr){
                if(i < str.length()){
                   if(smallestString.substring(0 , i).equals(str.substring(0 , i))){
                       cnt ++;
                   }else{
                       break;
                   }
                }
            }
            if(cnt == arr.length){
                ans = i;
            }
        }
        if(ans == -1){
            return "-1";
        }
        return smallestString.substring(0 , ans);
    }
}