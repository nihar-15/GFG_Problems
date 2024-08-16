<h2><a href="https://www.geeksforgeeks.org/problems/subset-with-sum-divisible-by-m2546/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card">Subset with sum divisible by k</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an array <strong>arr[] </strong>of positive integers and a value <strong>k.</strong> Return 1 if the sum of any subset(non-empty) of the given array is divisible by k otherwise, return 0.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [3, 1, 7, 5] , k=6
<strong>Output: </strong>1
<strong>Explanation: </strong>If we take the subset {7, 5} then sum will be 12 which is divisible by 6.</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [1, 2, 6] , k=5
<strong>Output: </strong>0
<strong>Explanation: </strong>All possible subsets of the given set are {1}, {2}, {6}, {1, 2}, {2, 6}, {1, 6} and {1, 2, 6}. There is no subset whose sum is divisible by 5.</span>
</pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:&nbsp;</strong>O(n*k)<br><strong>Expected Space Complexity:&nbsp;</strong>O(n)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 &lt;= arr.size(), k &lt;= 1000<br></span><span style="font-size: 18px;">1 &lt;= arr[i]&lt;= 1000</span></p>
<p>&nbsp;</p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Algorithms</code>&nbsp;<code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;