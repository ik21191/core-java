package problem.solving;

import java.util.Stack;

public class ValidateRegularExpression {

  public static boolean isValid(String expression) {

    Stack<Character> stack = new Stack<>();

    for (char c : expression.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (c != '(' && c != ')' && c != '{' && c != '}' && c != '[' && c != ']') {
        // System.out.println("not breakets");
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(ValidateRegularExpression.isValid("[{([2+3])}]"));
  }
}
