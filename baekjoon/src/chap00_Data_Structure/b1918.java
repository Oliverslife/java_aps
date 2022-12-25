package chap00_Data_Structure;

import java.util.Scanner;
import java.util.Stack;

public class b1918 {

    static int priority(char op) {

        if(op == '(' || op == ')')
            return 0;
        else if(op == '+' || op == '-')
            return 1;
        else if(op == '*' || op == '/')
            return 2;
        else
            return -1;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = sc.next();
        sc.close();

        Stack<Character> stack = new Stack<>();
        for(char ch : input.toCharArray()) {
            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(ch))
                        sb.append(stack.pop());
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '(')
                        sb.append(stack.pop());
                    stack.pop();
                    break;
                default:
                    sb.append(ch);
            }
        }

        while(!stack.isEmpty())
            sb.append(stack.pop());
        System.out.print(sb.toString());

    }
}
