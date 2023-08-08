package chap00_Data_Structure;

import java.util.Scanner;
import java.util.Stack;

public class b2504 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();

        int tmp = 1, ans = 0;
        char last = '\0';

        Stack<Character> stack = new Stack<>();
        for(char ch : input.toCharArray()) {
            if(ch == '(') {
                tmp *= 2;
                stack.push(ch);
            }
            else if(ch == '[') {
                tmp *= 3;
                stack.push(ch);
            }
            else if(ch == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    ans = 0;
                    break;
                }
                else if(last == '(')
                    ans += tmp;
                stack.pop();
                tmp /= 2;
            }
            else {
                if(stack.isEmpty() || stack.peek() != '[') {
                    ans = 0;
                    break;
                }
                else if(last == '[')
                    ans += tmp;
                stack.pop();
                tmp /= 3;
            }
            last = ch;
        }
        if(!stack.isEmpty())
            ans = 0;
        System.out.print(ans);
    }
}
