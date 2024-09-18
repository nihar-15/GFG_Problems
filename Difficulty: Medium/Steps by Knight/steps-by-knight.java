//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        if (KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1]) {
            return 0;
        }

        // Possible moves for the Knight
        int Xcord[] = {+2, +2, -2, -2, +1, +1, -1, -1};
        int Ycord[] = {+1, -1, +1, -1, +2, -2, +2, -2};

        // Boolean array to mark visited positions
        boolean[][] visited = new boolean[N + 1][N + 1];

        // Queue to perform BFS
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(KnightPos[0], KnightPos[1], 0));

        visited[KnightPos[0]][KnightPos[1]] = true;

        // BFS Loop
        while (!q.isEmpty()) {
            Position curr = q.poll();
            int curr_row = curr.x;
            int curr_col = curr.y;
            int curr_steps = curr.steps;

            // Explore all possible moves
            for (int i = 0; i < 8; i++) {
                int new_row = curr_row + Xcord[i];
                int new_col = curr_col + Ycord[i];

                // If the Knight reaches the target
                if (new_row == TargetPos[0] && new_col == TargetPos[1]) {
                    return curr_steps + 1;
                }

                // Check boundaries and if the position is visited
                if (new_row > 0 && new_row <= N && new_col > 0 && new_col <= N && !visited[new_row][new_col]) {
                    visited[new_row][new_col] = true;
                    q.offer(new Position(new_row, new_col, curr_steps + 1));
                }
            }
        }

        // If no path is found
        return -1;
    }
}
class Position{
    int x, y , steps ;
    Position(int x , int y , int steps){
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}