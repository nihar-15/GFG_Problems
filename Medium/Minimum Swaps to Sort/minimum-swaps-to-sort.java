//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here\
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            map.put(nums[i] , i);
        }
        Arrays.sort(nums);
        
        int ans =0 , left =0;
        
        while(left < nums.length){
            if(left == map.get(nums[left])){
                left++;
            }else{
                int t = nums[map.get(nums[left])];
                nums[map.get(nums[left])] = nums[left];
                nums[left] = t;
                ans++;
            }
        }
        return ans;
    }
}