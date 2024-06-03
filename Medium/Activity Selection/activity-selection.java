//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends


class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
      ArrayList<Job> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Job(start[i], end[i]));
        }

        // Sorting jobs according to their end times
        Collections.sort(arr);

        int count = 1; // The first activity is always selected
        int lastEndTime = arr.get(0).end;

        for (int i = 1; i < n; i++) {
            if (arr.get(i).start > lastEndTime) {
                count++;
                lastEndTime = arr.get(i).end;
            }
        }
        return count;
    }
}

class Job implements Comparable<Job> {
    int start, end;
    Job(int s, int e) {
        start = s;
        end = e;
    }

    // Sorting based on end times
    public int compareTo(Job other) {
        return this.end - other.end;
    }
}