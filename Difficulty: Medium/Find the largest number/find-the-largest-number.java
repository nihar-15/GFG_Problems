//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.find(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int find(int num){
        for(int i = num ; i > 1 ; i--){
            if(isNonDecreasing(Integer.toString(i))){
                return i;
            }
        }
        return 1;
    }
    static boolean isNonDecreasing(String s){
        for(int i =0 ; i< s.length()-1 ; i++){
            if(s.charAt(i) > s.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
}