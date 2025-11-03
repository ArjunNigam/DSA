import java.util.*;
import java.lang.*;
import java.io.*;

//TABULATION METHOD


class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int l = sc.nextInt();
		    int[] dp = new int[n+1];
		    dp[0] = 1;
		    for(int i=2;i<=n;i++)
		    {
		        for(int j=2;j<=l;j+=2)
		        {
		            if(i-j >=0)
		            {
		                dp[i] = (dp[i] +  dp[i-j])%1000000007;
		            }
		        }
		    }
		    System.out.println(dp[n]);
		}

	}
}
