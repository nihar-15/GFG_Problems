//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Integer arr[] = new Integer[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            obj.sortBySetBitCount(arr, n);
            StringBuilder output = new StringBuilder();
            for(int i = 0; i < n; i++)
            output.append(arr[i] + " ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute  
{ 
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        // Your code goes here
         Arrays.sort(arr,new cmp());
    } 
}

class cmp implements Comparator<Integer> {
       public int compare(Integer a,Integer b){
           int countA = countBits(a);
           int countB = countBits(b);
           
              if(countA<countB){
            return 1;
        }
        else if(countA>countB){
            return -1;
        }
      
            return 0;
        
       }
    
    
    static int countBits(int n ){
        if (n == 0){
            return n;
        }
        int  count =0;
        while( n > 0){
            n = n & (n-1);
            count ++;
        }
        return count;
    }
}
