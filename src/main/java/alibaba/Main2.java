package alibaba;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wangxiaomin03 on 17/4/26.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        scanner.close();
        int result=fun(line);
        System.out.print(result);

    }

    public static int fun(String s) {
        int Max = 16;
        Stack<Integer> stack = new Stack<Integer>();
        String[] strings = s.split("[\\s]+");
        int op1;
        int op2;
        for (String s1 : strings) {

            if ("^".equals(s1)) {
                if (stack.isEmpty()) {
                    return -1;
                }
                op1 = stack.pop();
                stack.push(op1 + 1);
            } else if ("+".equals(s1)) {
                if (stack.size() < 2) {
                    return -1;
                }
                op1 = stack.pop();
                op2 = stack.pop();
                stack.push(op1 + op2);
            } else if ("*".equals(s1)) {
                if (stack.size() < 2) {
                    return -1;
                }
                op1 = stack.pop();
                op2 = stack.pop();
                stack.push(op1 * op2);
            } else {
                stack.push(Integer.parseInt(s1));
                if (stack.size() > Max) {
                    return -2;
                }
            }
        }
        return stack.peek();
    }


}
