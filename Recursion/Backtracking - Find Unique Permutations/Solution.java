import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static Comparator<ArrayList<Integer>> subsetComparator = new Comparator<ArrayList<Integer>>()
    {
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2)
        {
            for(int i=0;i<o1.size();i++)
            {
                if(o1.get(i) != o2.get(i))
                {
                    return Integer.compare(o1.get(i), o2.get(i));
                }
            }
            return 0;
        }
    };
    
    public static void uniquePermuations(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> r, HashMap<Integer, Integer> frequency, int n)
    {
        if (r.size() == n)
        {
            result.add(new ArrayList<>(r));
            return ;
        }
        
        
        for(int element : frequency.keySet())
        {
            int frequencyOfElement = frequency.get(element);
            if(frequencyOfElement > 0)
            {
                r.add(element);
                frequency.put(element, frequencyOfElement - 1);
                uniquePermuations(result, r, frequency, n);
                frequency.put(element, frequencyOfElement);
                r.remove(r.size() -1);
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    ArrayList<Integer> A = new ArrayList<>();
		    for(int i =0;i<n;i++)
		    {
		        A.add(sc.nextInt());
		    }
		    Collections.sort(A);
		    HashMap<Integer, Integer> frequency = new HashMap<>();
		    for(int x : A)
		    {
		        frequency.put(x, frequency.getOrDefault(x, 0 ) + 1) ;
		    }
		    
		    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		    ArrayList<Integer> r = new ArrayList<>();
		    
		    uniquePermuations(result, r, frequency, n);
		    Collections.sort(result, subsetComparator);
		    System.out.println(result.size());
		    for(ArrayList<Integer> i : result)
		    {
		        for(int j = 0;j<i.size();j++)
		        {
		            System.out.print(i.get(j) + " ");
		        }
		        System.out.println();
		    }
		}

	}
}
