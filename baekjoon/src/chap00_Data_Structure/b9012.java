package chap00_Data_Structure;

import java.util.Scanner;
import java.util.Stack;

public class b9012 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        char[] target;
        boolean flag = true;
        while(input-- > 0) {
            target = sc.next().toCharArray();

            for(char ch : target) {
                if(ch == '(')
                    stack.push(ch);
                else if (!stack.isEmpty())
                    stack.pop();
                else {
                    flag = false;
                    break;
                }
            }

            sb.append(flag && stack.isEmpty() ? "YES" : "NO").append("\n");
            stack.clear();
            flag = true;
        }
        sc.close();
        System.out.print(sb);
    }
}
