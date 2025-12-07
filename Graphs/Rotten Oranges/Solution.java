import java.util.*;
public class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int countOfOnes = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                 if(A[i][j] == 2)
                 {
                     deque.addLast(new int[]{i,j});
                 }
                 else if(A[i][j] == 1)
                 {
                     countOfOnes++;
                 }
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int timer = 0; //Timer to calculate time 
        while(!deque.isEmpty())
        {
            int size = deque.size();
            boolean rottenThisMinute = false;
            while(size-- > 0)
            {
                int[] curr = deque.removeFirst();
                for(int[] dir : directions)
                {
                    int newI = curr[0] + dir[0];
                    int newJ = curr[1] + dir[1];
                    if(newI >= 0 && newI <n && newJ >= 0 && newJ <m && A[newI][newJ] == 1)
                    {
                        deque.add(new int[]{newI, newJ});
                        A[newI][newJ] = 2;
                        countOfOnes--;
                        rottenThisMinute = true;
                    }
                }
                
            }

            if(rottenThisMinute)
            {
                timer++;
            }
        }

        if(countOfOnes > 0)
        {
            return -1;
        }
        return timer;
        
    }
}
