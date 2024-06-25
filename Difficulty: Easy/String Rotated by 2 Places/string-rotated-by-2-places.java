//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        // Your code here
        
          int n1=str1.length();
        int n2 =str2.length();
        
        if(n1!=n2){
            return false;
        } 
        
        if (n1 < 2) {
            return str1.equals(str2);
        }
        
        String s1=str1.substring(n1-2)+str1.substring(0,n1-2);
        String s2=str1.substring(2)+str1.substring(0,2);
        
        if(str2.equals(s2) || str2.equals(s1)){
            return true;
        }
        return false;
    }
    
}