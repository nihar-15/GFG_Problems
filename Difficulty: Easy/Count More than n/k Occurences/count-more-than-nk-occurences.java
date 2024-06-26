//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] nums, int N, int k) 
    {
        // your code here,return the answer
        
         Map<Integer, Integer> countMap = new HashMap<>();

        for(int n : nums){
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);

            if(countMap.size() == k){ 
                Iterator iter = countMap.keySet().iterator();
                while(iter.hasNext()){
                    int key = (int) iter.next();
                    if(countMap.get(key) == 1){
                        iter.remove();
                    } else{
                        countMap.put(key, countMap.get(key)-1);
                    }
                }
            }
        }
        
        for(int key : countMap.keySet()){
            countMap.put(key, 0);
        }

        for(int n : nums){
            if(countMap.containsKey(n)){
                countMap.put(n, countMap.getOrDefault(n, 0)+1);
            }
        }

        int count = 0;
        for(int key : countMap.keySet()){
            if(countMap.get(key) > (N/k)){
                count++;
            }
        }
        return count;
    }
}
