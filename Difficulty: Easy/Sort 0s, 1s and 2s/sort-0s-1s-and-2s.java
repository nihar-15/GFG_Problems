//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
         int n=arr.size();
        int ca=0,cb=0,cc=0,i=0;
        for(i=0;i<n;i++)
        {
            if(arr.get(i)==0)
            {
                ca++;
            }
            else if(arr.get(i)==1)
            {
                cb++;
            }
            else{
                cc++;
            }
            
        }
        for(i=0;i<ca;i++)
        {
            arr.set(i , 0);
        }
        for( i=ca;i<ca+cb;i++)
        {
            arr.set(i , 1);
        }
        for(i=ca+cb;i<n;i++)
        {
            arr.set(i , 2);
        }
    }
}