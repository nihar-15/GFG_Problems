//{ Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


// Complete the function given below
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       // add your code here
       Arrays.sort(arr2);
       ArrayList<Integer> ans = new ArrayList<Integer>();
       for(int i =0 ; i < m ; i++){
           int a = upperBound(arr2 , arr1[i]);
           ans.add(a);
       }
       return ans;
    }
   static int upperBound(int arr[], int key) {
    int start = 0, end = arr.length - 1;
    int mid;
    
    while (start <= end) {
        mid = start + (end - start) / 2;
        if (arr[mid] <= key) {
            start = mid + 1;  // Move right since we want the upper bound
        } else {
            end = mid - 1;    // Move left to find a smaller number
        }
    }
    return start; // The upper bound index is the first index where arr[index] > key
}
}