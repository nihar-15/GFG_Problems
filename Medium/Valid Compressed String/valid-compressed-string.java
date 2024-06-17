//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
          int count = 0;

        for(int i=0;i<T.length();i++){

            char cur = T.charAt(i);

            if(cur>='A' && cur<='Z'){

                char check = S.charAt(count);
                if(check!=cur){
                    return 0;
                }
                else
                count++;

                continue;
            }
            int no=cur-'0';

            while(i+1<T.length() &&
                    T.charAt(i+1)>='0' &&
                    T.charAt(i+1)<='9'){
                i++;

                no = no*10;
                no = no + T.charAt(i) -'0';

            }

            count += no;
        }
        
        if(count!=S.length())
        return 0;
        
        return 1;
    }
}