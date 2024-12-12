//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        Solution ob = new Solution(); // Instantiate the Solution object once

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(ob.findMin(arr));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int n = arr.length;
         int l = 0;
        int r = n-1;
        int last = arr[r];
        while(l<r) 
        {
            int mid=l+(r-l)/2;
            if(arr[mid]>last) 
            {
                l=mid+1;
            } 
            else 
            {
                r=mid;
            }
        }
        return arr[l];
    }
}
