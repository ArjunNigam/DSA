public class Solution {
    public String solve(String A) {
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('^', 3);
        precedence.put('/', 2);
        precedence.put('*', 2);
        precedence.put('+', 1);
        precedence.put('-', 1);
        Stack<Character> operators = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(char a : A.toCharArray())
        {
            if(a >= 'a' && a <= 'z')
            {
                result.append(a);
            }
            else if(a == '(')
            {
                operators.push(a);
            }
            else if(a == ')')
            {
                while(!operators.isEmpty() && operators.peek() != '(')
                {
                    result.append(operators.pop());
                }
                operators.pop();
            }
            else // This character is an operator
            {
                while(!operators.isEmpty() && operators.peek() != '(' && precedence.get(operators.peek()) >= precedence.get(a))
                {
                    result.append(operators.pop());
                }
                operators.push(a);
            }
        }
        while(!operators.isEmpty())
        {
            result.append(operators.pop());
        }
        return result.toString();

    }
}
