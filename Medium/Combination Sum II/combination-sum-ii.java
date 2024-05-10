//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        func(arr, k, 0, ans, new ArrayList<>());
        return ans;
    }

    private void func(int arr[], int target, int idx, List<List<Integer>> ans, ArrayList<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return; // Return to avoid further recursion
        }

        for (int i = idx; i < arr.length; i++) {
            // Avoid processing duplicates
            if (i > idx && arr[i] == arr[i - 1]) {
                continue;
            }

            // If current element is greater than target, stop exploring further
            if (arr[i] > target) {
                break;
            }

            // Include current element and recurse with updated target
            list.add(arr[i]);
            func(arr, target - arr[i], i + 1, ans, list);
            list.remove(list.size() - 1); // Backtrack
        }
    }
}
 /*
    private void findCombinations(int[] arr, int target, int index, List<Integer> currentCombination, List<List<Integer>> results) {
        if (target == 0) { // If the target is reached
            results.add(new ArrayList<>(currentCombination));
            return; // Stop further recursion in this path
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue; // Avoid duplicates
            }

            if (arr[i] > target) {
                break; // Since array is sorted, no need to continue
            }

            currentCombination.add(arr[i]); // Add to the current combination
            findCombinations(arr, target - arr[i], i + 1, currentCombination, results); // Recurse with updated target
            currentCombination.remove(currentCombination.size() - 1); // Backtrack
        }
        
        */