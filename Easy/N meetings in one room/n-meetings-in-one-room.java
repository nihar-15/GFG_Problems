//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<timings> arr = new ArrayList<>();
        for(int i =0;i< n ; i++){
            arr.add(new timings(start[i] , end[i] , i));
        }
        Collections.sort(arr, new custom_cum());
        int limit = arr.get(0).end, count =1;
        
        for(int i =1;i<n;i++){
             if(arr.get(i).start>limit)
            {
                count++;
                limit= arr.get(i).end;
            }
        }
        return count;
    }
}


class timings
{
    int start;
    int end;
    int pos;
    timings(int start, int end, int pos)
    {
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}

class custom_cum implements Comparator<timings>
{
    public int compare(timings t1, timings t2)
    {
        if(t1.end!=t2.end)
            return t1.end-t2.end;
        return t1.pos-t2.pos;
    }
}