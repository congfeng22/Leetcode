import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String thing : tokens){
            if (thing.equals("+")) stack.add(stack.pop()+stack.pop());
            else if (thing.equals("-")) stack.add(-stack.pop()+stack.pop());
            else if (thing.equals("*")) stack.add(stack.pop()*stack.pop());
            else if (thing.equals("/")){
                int a = stack.pop();
                stack.add(stack.pop()/a);
            }
            else stack.add(Integer.parseInt(thing));
        }
        return stack.pop();
    }
    public static void main(String[] args){
        EvaluateReversePolishNotation150 test = new EvaluateReversePolishNotation150();
        System.out.println(test.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
