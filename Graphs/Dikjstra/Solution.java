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
    public int[] solve(int A, int[][] B, int C) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();  // Initializting the graph
        for(int i=0;i<A;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++) // Creating the graph
        {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u,w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(C, 0));
        int[] distance = new int[A];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[C] = 0;
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int v = curr.vertex;
            int w = curr.weight;
            for(Pair neighbhours : graph.get(v))
            {
                int distanceToReachNegh = w + neighbhours.weight;
                if(distance[neighbhours.vertex] > distanceToReachNegh)
                {
                    distance[neighbhours.vertex] = distanceToReachNegh;
                    pq.add(new Pair(neighbhours.vertex, distanceToReachNegh));
                }
            }
        }

        for(int i=0;i<A;i++)
        {
            if(distance[i] == Integer.MAX_VALUE)
            {
                distance[i] = -1;
            }
        }
        return distance;

    }
}
