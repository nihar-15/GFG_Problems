//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static int isPossible(String S){
        for(int i = 0 ; i < S.length() - 3; i++){
            for(int j = i+1 ; j< S.length() -2 ;j++){
                for(int k = j+1 ; k < S.length()-1; k++){
                     String part1 = S.substring(0, i+1);
                    String part2 = S.substring(i+1, j+1);
                    String part3 = S.substring(j+1, k+1);
                    String part4 = S.substring(k+1);

                    if (!part1.equals(part2) && !part1.equals(part3) && !part1.equals(part4)
                            && !part2.equals(part3) && !part2.equals(part4)
                            && !part3.equals(part4)) {
                        return 1; 
                }
            }
        }
        }
        return 0;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(s));
        }
    }
}

// } Driver Code Ends