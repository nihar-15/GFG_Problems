//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] v, int h) {
        // code here
         
        int low =1, high = findMax(v);
        while(low <= high){
            int mid = (low+high)/2;
            int totalH = calculateTotalHours(v, mid);
            if(totalH <= h){
                high = mid -1;
            
            }else{
                low = mid+1;
            }
            
            
        }
        return low;
        
    }
    
    
    static int calculateTotalHours(int v[] , int hourly){
        int totalH=0, n= v.length;
        
        
        for(int i=0;i<n;i++){
            totalH += Math.ceil((double)v[i]/(double)hourly);
                                
        }
                                
                                return totalH;
        
    }
                                
       static int findMax(int arr[]){
           int n = arr.length;
           int max= Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           max= Math.max(max, arr[i]);  
            //System.out.println(max);
        }
           return max;
    }
}
        
