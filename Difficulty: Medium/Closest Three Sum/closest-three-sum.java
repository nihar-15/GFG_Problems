//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int threeSumClosest(int[] ar, int target) {
      
        // code here
 Arrays.sort(ar);
        int ms= ar[0]+ar[1]+ar[ar.length-1];
        
        for(int i=0;i<ar.length-1;i++){
            int s=i+1;
           int  e=ar.length-1;
            
            while(s<e){
                
                int sum= ar[i]+ar[e]+ar[s];
                int  dif= Math.abs(sum-target);
                
                if(dif<Math.abs(ms-target)){
                    
                    ms=sum;
                }
                else if(dif==Math.abs(ms-target) && sum>ms){
                    ms=sum;
                }
                
                if(sum>target)e--;
                else s++;
                
            }
            
        }
        return ms;
        
        
    }
}
