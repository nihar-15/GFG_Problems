//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
       ArrayList<Integer> ans = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int distinctCount = 0;
        int left = 0, right = 0;
        
        while (right < n) {
            // Add element to the map
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            
            // Move left pointer until window size is greater than k
            while (right - left + 1 > k) {
                map.put(A[left], map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) {
                    map.remove(A[left]);
                }
                left++;
            }
            
            // If window size is equal to k, count distinct elements
            if (right - left + 1 == k) {
                ans.add(map.size());
            }
            
            right++;
        }
        
        return ans;
        
    }
}

