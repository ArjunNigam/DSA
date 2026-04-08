public class Solution {

    public int[] getPreviousSmaller(int[] A)
    {
        int n = A.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++)
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
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;

    }
    public int[] getNextSmaller(int[] A)
    {
        int n = A.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i =n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && A[stack.peek()] >= A[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                result[i] = n;
            }
            else 
            {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
    public int largestRectangleArea(int[] A) {
        int n = A.length;
        int[] nextSmaller = getNextSmaller(A);
        int[] previousSmaller = getPreviousSmaller(A);
        int answer = Integer.MIN_VALUE;
        for(int i =0;i<n;i++)
        {
            answer = Math.max(answer, A[i] * (nextSmaller[i] - previousSmaller[i] - 1));
        }
        return answer;
    }
}
