public class Solution {
    
    public int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();
        for(String a : A)
        {
            switch(a)
            {
                case "+" : 
                    {
                        stack.push(stack.pop() + stack.pop());
                        break;
                    }

                case "-" : 
                    { 
                        int y = stack.pop();
                        int x = stack.pop();
                        stack.push(x - y);
                        break;
                    }
                case "*" :
                    {
                        stack.push(stack.pop() * stack.pop());
                        break;
                    }
                case "/" :
                    {
                        int y = stack.pop();
                        int x = stack.pop();
                        stack.push(x/y);
                        break;
                    }
                default : 
                    {
                        stack.push(Integer.parseInt(a));
                    }
            }
        
        
        }
        return stack.pop();
    }
}   

