//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int n, int k)
    {
        // Write your code here
  // Step 1: Create an adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Step 2: Build the graph by comparing adjacent words
        for (int i = 0; i < n - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break; // only the first different character matters
                }
            }
        }
        
        // Step 3: Perform topological sort (Kahn's algorithm)
        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int v : adj.get(i)) {
                inDegree[v]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        StringBuilder order = new StringBuilder();
        
        // Add nodes with 0 in-degree to the queue
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        // BFS (Kahn's Algorithm)
        while (!q.isEmpty()) {
            int u = q.poll();
            order.append((char)(u + 'a'));
            
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        
        // If the order has the same number of characters as k, it's valid
        if (order.length() == k) {
            return order.toString();
        }
        
        return "";
     }
}