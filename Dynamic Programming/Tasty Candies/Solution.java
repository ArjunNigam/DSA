import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    public static long MaxSubarraySum(int[] A, int n)
    {
        long globalMax = Integer.MIN_VALUE, currentSum = 0;
        for(int i=0;i<n;i++)
        {
            currentSum += A[i];
            globalMax = Math.max(globalMax, currentSum);
            if(currentSum < 0)
            {
                currentSum = 0;
            }
        }
        return globalMax;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int[] A = new int[n];
		    int[] T = new int[n];
		    int type1count = 0, type0count = 0;
		    for(int i=0;i<n;i++)
		    {
		        A[i] = sc.nextInt();
		    }
		    for(int i=0;i<n;i++)
		    {
		        T[i] = sc.nextInt();
		        if(T[i] == 1)
		        {
		            type1count++;
		        }
		        else 
		        {
		            type0count++;
		        }
		    }
		    int A1[] = new int[type1count];
		    int A0[] = new int[type0count];
		    int c1 = 0, c0 =0;
		    for(int i=0;i<n;i++)
		    {
		        if(T[i] == 1)
		        {
		            A1[c1++] = A[i];
		        }
		        else 
		        {
		            A0[c0++] = A[i];
		        }
		    }
		    // Now we will calculate MaxSubarraySum in both A0 and A1
		    long max1 = MaxSubarraySum(A0, type0count);
		    long max2 = MaxSubarraySum(A1, type1count);
		    System.out.println(Math.max(max1, max2));
		    
		}

	}
}
