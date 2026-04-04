public class Solution {
    public int solve(int A, int B, int[] C) {
        Stack<Integer> stack = new Stack<>();
        stack.push(B); // Initial player who has the ball
        for(int c : C)
        {
            if(c == 0)
            {
                stack.pop();   // The previous player has the ball
            }
            else 
            {
                stack.push(c); // Player with ID c has the ball 
            }
        }

        return stack.peek();
    }
}
