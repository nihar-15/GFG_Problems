//{ Driver Code Starts
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}


// } Driver Code Ends


/*you are required to complete this method */
class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
            //Your code here
          if(a.length() +b.length() != c.length()){
                return false;
            }
            Boolean dp[][] = new Boolean[a.length()+1][b.length()+1];
            return func(a, b, c , 0 , 0, dp);
           // return lcsA+ lcsB == c.length();
	}


   public boolean  func(String s1 , String s2 , String s3 , int i , int j, Boolean dp[][]) {
        if( i == s1.length() && j == s2.length()){
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            boolean f = func(s1 ,s2 ,s3, i+1, j , dp);
            dp[i][j] = f;
            if(f == true){
                return true;
            }
        }
             if(j  < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            boolean f = func(s1 ,s2 ,s3, i, j+1 , dp);
            dp[i][j] = f;
            if(f == true){
                return true;
            }
             }

        dp[i][j] = false;
        return false;
   }
}

