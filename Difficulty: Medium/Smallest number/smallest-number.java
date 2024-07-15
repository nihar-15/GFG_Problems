//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        int st = (int) Math.pow(10,d-1);
        int end = (int) Math.pow(10,d) - 1;
        for(int i = st ; i <= end ; i++) {
            if (sum(i) == s) {
                return String.valueOf(i);
            }
        }
        return String.valueOf(-1);
        // code here
    }
    
    private static int sum(int n){
        int tmp = 0;
        while (n>0){
            int d = n%10;
            tmp += d;
            n /= 10;
        }
        return tmp;
    }
}
