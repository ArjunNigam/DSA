import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    public static void getUniqueCombinations(int B, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> r, int[] A, int index)
    {
        
        if(B == 0)
        {
            result.add(new ArrayList<>(r));
            return;
        }
        if(B < 0)
        {
            return;
        }
        
        for(int i=index;i<A.length;i++)
        {
            r.add(A[i]);
            getUniqueCombinations(B-A[i], result, r, A, i);
            r.remove(r.size()-1);
        }
        
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    int b = sc.nextInt();
		    int[] A = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        A[i] = sc.nextInt();
		    }
		
		    Arrays.sort(A);
    		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    		ArrayList<Integer> r = new ArrayList<>();
    		getUniqueCombinations(b, result, r, A,0);
    		System.out.println(result.size());
    		for(ArrayList<Integer> x : result)
    		{
    		    for(int i : x)
    		    {
    		        System.out.print(i + " ");
    		    }
    		    System.out.println();
    		}
    		
		
		}
		
		

	}
}
