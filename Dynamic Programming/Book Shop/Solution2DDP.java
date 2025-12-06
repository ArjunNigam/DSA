//dp[i][j] = Max number of pages that we can buy with j money and (0th...ith) books.

//dp[i][j] = Max(Not taking the ith book and continuing with pages we had with i-1 books and j money
//               , Pages of ith book + Number of pages we had with (i-1)th books and j-Price of ith book )

//dp[i][j] = Max(dp[i-1][j], Pages[i] + dp[i-1][j - Price[ith book]])
import java.util.*;
public class Solution2DDP {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] prices = new int[n];
        int[] pages = new int[n];
        for(int i=0;i<n;i++)
        {
            prices[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            pages[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][x+1]; //The first row is dummy row (no books) and the first column is the column where we have 0 money. 
                                        //Hence the first row will be 0, because we cannot have any pages if we don't have any books, even if we have money.
                                        //The first column will be 0 because we won't have any pages, even if we have books because we have 0 money
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=x;j++)
            {
                dp[i][j] = dp[i-1][j]; // Not taking the ith book
                if(j >= prices[i-1])// Taking the ith book
                {
                    dp[i][j] = Math.max(dp[i][j], pages[i-1] + dp[i-1][j-prices[i-1]]);
                }
                
            }
        }

        System.out.println(dp[n][x]);
        
    }
}