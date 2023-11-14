//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {

        
        
       ArrayList<ArrayList<String>> ans=new ArrayList<>();
        List<String> path =new ArrayList<>();
        
        fun(s,ans,path,0);
        return ans;
    }
    
      public static void fun(String a,ArrayList<ArrayList<String>> ans,List<String> path,int idx){
       
        
        if(idx==a.length()){
            ans.add(new ArrayList<>(path));
        }
        
        for(int i=idx;i<a.length();i++){
            if(isPalindrome(a,idx,i)){
                path.add(a.substring(idx,i+1));
                fun(a,ans,path,i+1);
                path.remove(path.size() - 1);
            }
        }
    }
    
    
    public static boolean isPalindrome(String s,int start,int end){
        
         while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

};