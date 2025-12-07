//This question can be solved by Minimum Spanning Tree (MST)
import java.util.*;
public class Solution {
    public class Pair {
        int vertex, weight;
        public Pair(int vertex, int weight)
        {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public int solve(int A, int[][] B) {
        ArrayList<Pair>[] graph = new ArrayList[A+1];
        int n = B.length;
        for(int i=1;i<=A;i++)
        {
            graph[i] = new ArrayList<>();
        }
        int MOD = 1000000007;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        for(int i=0;i<n;i++)
        {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            graph[u].add(new Pair(v,w));
            graph[v].add(new Pair(u,w));
        }
        boolean[] visited = new boolean[A+1];
        //We will take 1 as the source node and add all its corresponding edges to the minHeap
        for(Pair p : graph[1])
        {
            pq.add(p);
        }
        visited[1] = true;
        int cost = 0;
        while(!pq.isEmpty())
        {
            Pair currentMin = pq.poll();
            if(!visited[currentMin.vertex])
            {
                visited[currentMin.vertex] = true;
                cost = (cost + currentMin.weight) % MOD;
                for(Pair p : graph[currentMin.vertex])
                {
                    if(!visited[p.vertex])
                    {
                        pq.add(p);
                    }
                }
            }
        }

        return cost;

    }
}
