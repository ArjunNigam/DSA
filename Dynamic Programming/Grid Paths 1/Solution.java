import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        int MOD = 1000000007;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for(int i = 0;i<n;i++)
        {
            String row = sc.next();
            for(int j=0;j<n;j++)
            {
                grid[i][j] = row.charAt(j);
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = (grid[0][0] == '*' ? 0:1);
        for(int i=1;i<n;i++)
        {
            if(grid[i][0] == '*')
            {
                dp[i][0] = 0;
            }
            else 
            {
                dp[i][0] = dp[i-1][0];
            }
        }

        for(int j=1;j<n;j++)
        {
            if(grid[0][j] == '*')
            {
                dp[0][j] = 0;
            }
            else
            {
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(grid[i][j] == '*')
                {
                    dp[i][j] = 0;
                }
                else 
                {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j])%MOD;
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}