//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        Set<Integer> S1=new LinkedHashSet<>();
        Set<Integer> S2=new  LinkedHashSet<>();
        Set<Integer> S3=new  LinkedHashSet<>();
        
        for(int i=0;i<n1;i++)
        {
            
            if(!S1.contains(A[i]))
            
                S1.add(A[i]);
            
        }
        for(int i=0;i<n2;i++)
        {
            if(S1.contains(B[i]))
            
                S2.add(B[i]);
            
        }
        for(int i=0;i<n3;i++)
        {
            if(S2.contains(C[i]))
            
                S3.add(C[i]);
            
        }
        
        return new ArrayList<>(S3);
       
    }
}