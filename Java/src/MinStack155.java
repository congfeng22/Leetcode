import java.util.Stack;

public class MinStack155 {
    Stack<Integer> stack;
    int min;
    public MinStack155() {
        stack = new Stack();
    }

    public void push(int x) {
        if (stack.isEmpty()) min = x;
        else min = Math.min(min,x);
        stack.add(x);
        stack.add(min);
    }

    public void pop() {
        stack.pop();
        stack.pop();
        if (!stack.isEmpty()) min = stack.peek();
    }

    public int top() {
        int temp = stack.pop();
        int ret = stack.peek();
        stack.add(temp);
        return ret;
    }

    public int getMin() {
        return stack.peek();
    }
}
