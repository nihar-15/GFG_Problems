//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {

    public boolean checkSorted(List<Integer> arr) {
        // code here
          int swaps=0;
        for(int i=0;i<arr.size();i++){
            if(swaps>2)
            return false;
            if(i+1==arr.get(i)) continue;
            
            int a = arr.get(i);
            int b = arr.get(a-1);
         
            if(i+1==arr.get(a-1) && arr.get(a-1)==b  ){
                swaps++;
                Collections.swap(arr, i, a-1);
            }
            else
            swaps+=2;
            /*
            Definitely we require more than one swaps(atleast 2 or at max as 
            per requirement) if proper index match not occur in above 
            condition becouse we need further swaps in order to place the 
            element at their correct position.
            */
            }
        return true;
    }
}