//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]),
                                  Integer.parseInt(inputLine[k++]));
            }
            System.out.println(
                String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class CustomComparator implements Comparator<Item>{
    public int compare(Item i1 , Item i2){
        double ratio1 = (double)i1.value / i1.weight;
        double ratio2 = (double)i2.value / i2.weight;
        
        if(ratio1 > ratio2){
            return -1;
        }
        if(ratio1 < ratio2){
            return 1;
        }
        
        return 0;
    }
}

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr , new CustomComparator());
        double ans = 0.0;
        
        for(int i = 0; i < n; i++){
            if(arr[i].weight <= w){
                ans += arr[i].value;
                w -= arr[i].weight;
            } else {
                ans += (double)arr[i].value * ((double)w / (double)arr[i].weight);
                break;  // Once the knapsack is full, exit the loop
            }
        }
        return ans;
    }
}
