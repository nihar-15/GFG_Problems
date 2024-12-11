//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void mergeArrays(int arr1[], int arr2[]) 
    {
        // code here 
        int n = arr1.length; 
        int m = arr2.length ;
        
     int left=n-1,right=0;
        while (left>=0 && right<m) {
            if (arr1[left] > arr2[right]) {
              //  System.out.println("Swapping");
                swap(arr1, arr2, left, right);
             left--;
            right++;
            } else {
break;
              
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void swap(int[] arr1, int[] arr2, int index1, int index2) {
        //System.out.println("Swapping " + arr1[index1] + " and " + arr2[index2]);
        int temp = arr1[index1];
        arr1[index1] = arr2[index2];
        arr2[index2] = temp;
        //System.out.println("Swapped " + arr1[index1] + " and " + arr2[index2]);
    }
}
