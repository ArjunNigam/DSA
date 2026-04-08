public class Solution {
    public String solve(String A) {
        Stack<Character> stack = new Stack<>();
        for(char a : A.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek() == a)
            {
                stack.pop();
                continue;
            }
            else
            {
                stack.push(a);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
        {
            result.append(stack.pop());
        }
        result.reverse();
        return result.toString();

    }
}
