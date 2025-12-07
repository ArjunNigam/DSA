//This question can be solved by doing a normal dfs traversal on the 2D matrix.
import java.util.*;
public class Solution {

    public void dfs(char[][] arr, boolean[][] visited, int[][] directions, int i, int j)
    {
        visited[i][j] = true;
        arr[i][j] = 'Y';
        for(int[] dir : directions)
        {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(newI >= 0 && newI < arr.length && newJ >= 0 && newJ <arr[0].length && !visited[newI][newJ] && arr[newI][newJ] == 'X')
            {
                dfs(arr, visited, directions, newI, newJ);
            }
        }
    }
    public int black(String[] A) {
        int n = A.length, m = A[0].length();
        char[][] arr = new char[n][m];
        for(int i=0;i<A.length;i++)
        {
            arr[i] = A[i].toCharArray();
        }
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        int countOfShapes = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j] && arr[i][j] == 'X')
                {
                    countOfShapes++;
                    dfs(arr, visited, directions, i,j);
                }
            }
        }

        return countOfShapes;
    }
}
