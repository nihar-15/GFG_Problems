//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    void nextPermutation(int[] nums) {
        // code here
        
         ArrayList<Integer> arr=new ArrayList<>();
        for(int num:nums){
            arr.add(num);
        }
        int n=arr.size();
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(arr.get(i)<arr.get(i+1)){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            Collections.reverse(arr);
            //return arr;
        }
        else{
            for(int i=n-1;i>idx;i--){
            if(arr.get(i)>arr.get(idx)){
                int temp=arr.get(i);
                arr.set(i,arr.get(idx));
                arr.set(idx,temp);
                break;
            }
        }
        List<Integer> sublist=arr.subList(idx+1,n);
        Collections.reverse(sublist);
        } 
        for(int i=0;i<arr.size();i++){
            nums[i]=arr.get(i);
        }
    }
}

//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends