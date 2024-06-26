//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
            List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        
        for(int num : arr){
            if(num>=0){
                pos.add(num);
            }else{
                neg.add(num);
            }
        }
        int i=0,j=0,k=0;
        while(i<pos.size() && j<neg.size()){
            arr[k] = pos.get(i);
            k++;
            arr[k] = neg.get(j);
            k++;
            i++;j++;
        }
        while(i<pos.size()){
            arr[k] = pos.get(i);
            i++;k++;
        }
        while(j<neg.size()){
            arr[k] = neg.get(j);
            j++;k++;
        }
    }
}