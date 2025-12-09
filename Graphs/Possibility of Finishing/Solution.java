import java.util.*;
public class Solution {
    //This can be solved by Topological Sort
    public int solve(int A, int[] B, int[] C) {
        
        ArrayList<Integer>[] graph = new ArrayList[A+1];
        int[] indegree = new int[A+1];
        for(int i = 1;i<=A;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<B.length;i++)
        {
            int u = B[i];
            int v = C[i];
            graph[u].add(v);
            indegree[v]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1;i<=A;i++)
        {
            if(indegree[i] == 0)
            {
                deque.addLast(i);
            }
        }

        while(!deque.isEmpty())
        {
            
            int curr = deque.pollFirst();
            for(int neighbour : graph[curr])
            {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                {
                    deque.addLast(neighbour);
                }
            }

        }

        for(int i : indegree)
        {
            if(i > 0)
            {
                return 0;
            }
        }
        return 1;


        
    }
}
