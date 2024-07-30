//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    int m  , n;
    public ArrayList<String> findPath(int[][] mat) {
       m = mat.length;
       n = mat[0].length ;
       ArrayList<String> ans = new ArrayList<>();
       String empty ="";
       func(mat , ans , 0 , 0, m ,n , "");
       
       return ans;

    }
    void func(int mat[][] ,ArrayList<String> ans , int r , int c , int m , int n, String str ){
        if(r <  0 || c< 0 || r>= m || c>= n ){
            return ;
        }
        if(mat[r][c] == -1 || mat[r][c] == 0){
            return ;
        }
        
         if (r==mat.length-1 && c==mat[0].length-1 && mat[r][c]==1){
            ans.add(str);
            return;
        }
        mat[r][c] = -1;
        func(mat, ans , r+1 , c , m ,n , str+"D");
        func(mat , ans , r - 1 , c , m ,n , str+"U");
        func(mat , ans , r , c-1 , m ,n , str +"L");
        func(mat , ans , r , c+1 , m ,n, str+"R");
        mat[r][c] =1;
    }

    
}