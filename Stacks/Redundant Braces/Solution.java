public class Solution {

    public boolean isOperator(char a)
    {
         if(a == '+' || a =='/' || a == '*' || a == '-')
         {
             return true;
         }
         return false;
    }
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        
        for(char a : A.toCharArray())
        {
            if(a == '(')
            {
                stack.push(a);
            }
            else if(a == ')')
            {
                if(isOperator(stack.peek()))
                {
                    while(stack.peek() != '(')
                    {
                        stack.pop();
                    }
                    stack.pop();
                }
                else
                {
                    return 1;
                }
                
            }
            else if(a == '+' || a =='/' || a == '*' || a == '-')
            {
                stack.push(a);
            }
        }

        return 0;


    }
}
