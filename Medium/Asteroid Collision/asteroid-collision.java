//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        int[] stack = new int[asteroids.length];
        int top = -1; 
        for (int g : asteroids) {
            if (top == -1) {
                stack[++top] = g;
            } else {
                if (g < 0) {
                    if (stack[top] < 0) {
                        stack[++top] = g;
                    } else {
                        while (top >= 0 && stack[top] > 0 && stack[top] < (-g)) {
                            top--;
                        }
                        if (top >= 0) {
                            if (stack[top] > 0 && stack[top] == (-g)) {
                                top--;
                            } else if (stack[top] < 0) {
                                stack[++top] = g;
                            }
                        } else {
                            stack[++top] = g;
                        }
                    }
                } else {
                    stack[++top] = g;
                }
            }
        }
        int[] ans = new int[top + 1];
        for (int i = 0; i <= top; i++) {
            ans[i] = stack[i];
        }
        return ans;
    }
}
