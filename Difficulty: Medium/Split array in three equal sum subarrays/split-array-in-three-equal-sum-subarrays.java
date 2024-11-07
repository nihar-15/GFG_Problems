//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        
       int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];

        // Calculate prefix sum
        for (int i = 1; i < n; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        int totalSum = prefixSum[n - 1];

        // If total sum is not divisible by 3, return {-1, -1}
        if (totalSum % 3 != 0) {
            return Arrays.asList(-1, -1);
        }

        int target1 = totalSum / 3;       // First split point
        int target2 = 2 * target1;        // Second split point

        int firstSplit = -1;
        int secondSplit = -1;

        // Find the first and second split indices
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == target1 && firstSplit == -1) {
                firstSplit = i;          // First split index found
            } else if (prefixSum[i] == target2 && firstSplit != -1) {
                secondSplit = i;         // Second split index found
                break;                   // Both indices found, exit loop
            }
        }

        // If valid indices found, return them
        if (firstSplit != -1 && secondSplit != -1) {
            return Arrays.asList(firstSplit, secondSplit);
        }

        // Otherwise, return {-1, -1}
        return Arrays.asList(-1, -1);
    
       
    }
}