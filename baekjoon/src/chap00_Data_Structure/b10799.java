package chap00_Data_Structure;

import java.util.Scanner;
import java.util.Stack;

public class b10799 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();

        Stack<Character> stack = new Stack<>();
        int ans = 0;
        char last = '\0';

        for(char ch : input.toCharArray()) {
            if(ch == '(')
                stack.push(ch);
            else {
                if(last != ch) {
                    stack.pop();
                    ans += stack.size();
                }
                else {
                    stack.pop();
                    ans += 1;
                }
            }
            last = ch;
        }

        System.out.print(ans);
    }
}
