public class Solution {
    public int[] prevSmaller(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(int i =0;i<n;i++)
        {
            while(!stack.isEmpty() && A[stack.peek()] >= A[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                result[i] = -1;
            }
            else 
            {
                result[i] = A[stack.peek()];
            }
            stack.push(i);
        }

        return result;
    }
}
