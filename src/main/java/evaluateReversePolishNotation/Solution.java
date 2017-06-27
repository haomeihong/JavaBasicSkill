package evaluateReversePolishNotation;

import java.util.IdentityHashMap;
import java.util.Stack;

/**
 * Created by wangxiaomin03 on 17/4/26.
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int var1;
        int var2;
        for (String s : tokens) {
            if ("+".equals(s)) {
                var1 = stack.pop();
                var2 = stack.pop();
                stack.push(var2 + var1);
            } else if ("-".equals(s)) {
                var1 = stack.pop();
                var2 = stack.pop();
                stack.push(var2 - var1);
            } else if ("*".equals(s)) {
                var1 = stack.pop();
                var2 = stack.pop();
                stack.push(var2 * var1);
            } else if ("/".equals(s)) {

                var1 = stack.pop();
                var2 = stack.pop();
                stack.push(var2 /var1);

            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
public static void main(String[] args){
    Solution solution=new Solution();
    int result=solution.evalRPN(new String[]{"2", "1", "+", "3", "*"});
    System.out.println(result);

}
}
