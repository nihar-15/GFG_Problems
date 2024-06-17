//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        //your code here
        
        if(n == 1){
            return "1";
        }

        String str = lookandsay(n-1);
       String result = "";
    
       for(int i =0;i< str.length() ; i++){
         int count = 1;
         char curChar = str.charAt(i);

         while( i <  str.length()-1 && str.charAt(i) == str.charAt(i+1)){
            i ++;
            count++;
         }

         result += Integer.toString(count)+Character.toString(curChar);
       }
       return result;
    }
}
