//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        
        Map<String, Integer> voteCount = new HashMap<>();

        // Iterate through the array and update the vote count.
        for (String candidate : arr) {
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        }

        // Variables to keep track of the candidate with maximum votes and the lexicographically smallest name.
        String maxVotesCandidate = "";
        int maxVotes = 0;

        // Iterate through the HashMap to find the candidate with maximum votes.
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            String candidate = entry.getKey();
            int votes = entry.getValue();

            // Update the result based on the conditions.
            if (votes > maxVotes || (votes == maxVotes && candidate.compareTo(maxVotesCandidate) < 0)) {
                maxVotes = votes;
                maxVotesCandidate = candidate;
            }
        }

        // Return the result in the required format.
        return new String[]{maxVotesCandidate, Integer.toString(maxVotes)};
    
    }
}

