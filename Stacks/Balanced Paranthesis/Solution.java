public class Solution {
    public int solve(String A) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}' , '{');
        map.put(')' , '(');
        map.put(']' , '[');
        Stack<Character> stack = new Stack<>();
        for(char ch : A.toCharArray())
        {
            if(ch == '{' || ch == '(' || ch == '[')
            {
                stack.push(ch);
            }
            else
            {
                if(!stack.isEmpty() && stack.peek() == map.get(ch))
                {
                    stack.pop();
                }
                else 
                {
                    return 0;
                }
            }
        }
        if(stack.isEmpty()) return 1;
        return 0;
    }
}
