// 1D DP Solution
import java.util.*;
public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int MOD = 1000000007;
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        // dp[i] = number of ways to get sum i using the faces of dice (1 to 6)
        dp[0] = 1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=6;j++)
            {
                if(i >= j) // If the sum is greater than or equal to the face value, then we can use that face value
                {
                    dp[i] = (dp[i] + dp[i-j]) % MOD; // dp[5] = dp[5-1] + dp[5-2] + dp[5-3] + dp[5-4] + dp[5-5] + dp[5-6]
                                                     // i.e for dp[i], the number of ways to get i, will be the sum of number of ways to get (i-1), (i-2), (i-3), (i-4), (i-5), (i-6)
                                                     // because let's say there are 4 ways to get dp[3-1] = dp[2], then we can add a face value of 1 to each of those 4 ways to get dp[3]
                                                     // Similarly let's say there are 5 ways to get dp[3-2] = dp[1], then we can add a face value of 2 to each of those 5 ways to get dp[3]
                                                     // So total number of ways to get dp[3] will be dp[3-1] + dp[3-2] = 4 + 5 = 9 
                }
            }
        }

        System.out.println(dp[n]);
    }
}