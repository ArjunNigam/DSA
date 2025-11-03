import java.util.*;
import java.lang.*;
import java.io.*;

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
    		int[] h = new int[n];
    		int[] iq = new int[n];
    		for(int i=0;i<n;i++)
    		{
    		    h[i] = sc.nextInt();
    		}
    		for(int i=0;i<n;i++)
    		{
    		    iq[i] = sc.nextInt();
    		}
    		
    		int[] dp = new int[n];
    		Arrays.fill(dp, 1); // Each student can be a subsequence themselves
    		
    		for(int i=1;i<n;i++)
    		{
    		    for(int j=i-1;j>=0;j--)
    		    {
    		        if(h[i] > h[j] && iq[i] < iq[j])
    		        {
    		            dp[i] = Math.max(dp[i], dp[j] + 1);
    		        }
    		    }
    		}
    		
    		int max = dp[0];
    		for(int i : dp)
    		{
    		    max = Math.max(i, max);
    		}
    		System.out.println(max);
		}
		
		
		

	}
}
