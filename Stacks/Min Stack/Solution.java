class Solution {

    int[] stack = new int[(int)(Math.pow(10,6))];
    int[] minStack = new int[(int)(Math.pow(10,6))];
    int top = -1, minTop = -1;
    public void push(int x) {

        stack[++top] = x;
        if(minTop == -1 || minStack[minTop] >= x)
        {
            minStack[++minTop] = x;
        }
        
    }

    public void pop() {

        if(top == -1)
        {
            return;
        }
        int poppedElement = stack[top];
        top--;
        if(poppedElement == minStack[minTop])
        {
            minTop--;
        }
        
    }

    public int top() {

        if(top == -1)
        {
            return -1;
        }

        return stack[top];
        
    }

    public int getMin() {
        if(minTop == -1)
        {
            return -1;
        }
        return minStack[minTop];
        
    }
}
