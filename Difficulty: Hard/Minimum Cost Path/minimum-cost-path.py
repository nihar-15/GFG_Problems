class Solution:
    
    #Function to return the minimum cost to react at bottom
	#right cell from top left cell.
	def minimumCostPath(self, grid):
	    n = len(grid)
        dp = [[1000000] * n for _ in range(n)]
        dp[0][0] = grid[0][0]
        for _ in range(2):
            for i in range(n):
                for j in range(n):
                    if i != 0:
                        dp[i - 1][j] = min(dp[i - 1][j], dp[i][j] + grid[i - 1][j])
                    if j != 0:
                        dp[i][j - 1] = min(dp[i][j - 1], dp[i][j] + grid[i][j - 1])
                    if i != n - 1:
                        dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + grid[i + 1][j])
                    if j != n - 1:
                        dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + grid[i][j + 1])
        return dp[-1][-1]


#{ 
 # Driver Code Starts

T=int(input())
for i in range(T):
	n = int(input())
	grid = []
	for _ in range(n):
		a = list(map(int, input().split()))
		grid.append(a)
	obj = Solution()
	ans = obj.minimumCostPath(grid)
	print(ans)

# } Driver Code Ends