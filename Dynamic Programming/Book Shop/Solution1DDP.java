//dp[i][j] = Max number of pages that we can buy with j money and (0th...ith) books.

//dp[i][j] = Max(Not taking the ith book and continuing with pages we had with i-1 books and j money
//               , Pages of ith book + Number of pages we had with (i-1)th books and j-Price of ith book )

//dp[i][j] = Max(dp[i-1][j], Pages[i] + dp[i-1][j - Price[ith book]])
import java.util.*;
public class Solution1DDP {
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

        int[] prev = new int[x+1];
        int[] curr = new int[x+1];

        for(int i=0;i<n;i++)
        {
            for(int j=1;j<=x;j++)
            {
                curr[j] = prev[j]; //Not taking the element
                if(j >= prices[i])
                {
                    curr[j] = Math.max(curr[j], pages[i] + prev[j-prices[i]]);
                }
            }
            prev = Arrays.copyOf(curr, x+1);
        }
        

        System.out.println(curr[x]);
    }
}