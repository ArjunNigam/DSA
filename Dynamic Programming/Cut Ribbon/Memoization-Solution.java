import java.util.*;
import java.lang.*;
import java.io.*;
//MEMOIZATION METHOD
class Codechef
{
    
    public static int solve(int length, int cutSize, HashMap<Integer, Integer> dp)
    {
        if(length == 0)
        {
            return 1;
        }
        if(length < 0)
        {
            return 0;
        }
        
        if(dp.containsKey(length)) return dp.get(length);
        
        int totalWays = 0;
        for(int l = 2; l <= cutSize; l+=2)
        {
            totalWays = (totalWays + solve(length - l, cutSize, dp))%1000000007;
        }
        dp.put(length, totalWays);
        return totalWays;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int l = sc.nextInt();
		    HashMap<Integer, Integer> dp = new HashMap<>();
		    System.out.println(solve(n, l, dp));
		    
		}
		

	}
}
