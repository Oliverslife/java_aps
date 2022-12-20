package chap00_Data_Structure;

import java.util.Scanner;
import java.util.Stack;

public class b1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int cur = 0;

        while(n-- > 0) {
            int target = sc.nextInt();

            if(cur < target) {
                for (int i = cur; i < target; i++) {
                    stack.push(i + 1);
                    sb.append("+").append("\n");
                }
                cur = target;
            }
            else if(stack.peek() != target) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }

            stack.pop();
            sb.append("-").append("\n");
        }
        sc.close();

        System.out.print(sb);
    }
}
