//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        // Your code here
        if(n ==1){
            return 1;
        }
        long low = 0 , high = n /2;
        while(low <= high){
            long mid = (low + high) / 2;
            if((mid*mid) <= n){
                low = mid +1 ;
            }else{
                high = mid -1;
            }
        }
        return high;
    }
}
