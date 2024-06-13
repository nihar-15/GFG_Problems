//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
     
       if(n==0 || n==1 || n==2)
        {
            return 1;
        }
        if(n==3 || n==4 )
            return 2;
        if(n==5)
            return 3;         
        int p0=2,p1=2,p2=3,p3=2;
        int r1=0,r2=0;
        for(int i=6;i<=n;i=i+2 )
        {
            r1=(p0+p1)%1000000007;
            r2=(p2+p3)%1000000007;
            p0=r1;
            p1=p2;
            p2=r2;
            p3=r1;
        }
        if(n%2==0)
            return r1;
        else
            return r2;   
        //code here.
    }
    
}
