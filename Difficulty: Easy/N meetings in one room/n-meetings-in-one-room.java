//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int maxMeetings(int n, int start[], int end[]) {
     ArrayList<Meeting> arr = new ArrayList<>();
     for(int i = 0 ;i< n ; i++){
         arr.add(new Meeting(start[i] , end[i]));
     }
     Collections.sort(arr);
     int endTime = arr.get(0).end;
     int cnt = 1 ;
     // arr.get(0).tostring();
     for(int i = 1 ; i < n ; i++){
      // arr.get(i).tostring();
         if(arr.get(i).start > endTime){
             cnt++;
             endTime = arr.get(i).end;
         }
     }
     return cnt;
    }
}
class Meeting implements Comparable<Meeting>{
    int start , end ;
    
    Meeting(int s , int e){
        start = s;
        end = e;
    }
    public int compareTo(Meeting m) {
    return Integer.compare(this.end, m.end);
}

    public void tostring(){
        System.out.println(this.start +" " + this.end);
    }
}
