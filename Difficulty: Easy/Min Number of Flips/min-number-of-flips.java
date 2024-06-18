//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.minFlips(S));
                        
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minFlips(String S) {
        // Code here
        
         int a =S.length();

int flippingpatternA = 0;
int flippingpatternB = 0;
for(int i =0;i<a;i++){
    char expectedA;
    char expecterB;
    if(i%2 ==0){  // if even location p zero h then vaise hi string hogi 
        expectedA = '0';
        expecterB = '1';
    }else{
        expectedA = '1'; // even location p one present h 
        expecterB = '0';
    }
if(S.charAt(i)!=expectedA){
    flippingpatternA++;
}
if(S.charAt(i)!=expecterB){
    flippingpatternB++;
}


}

    return Math.min(flippingpatternA,flippingpatternB); 
    }
}