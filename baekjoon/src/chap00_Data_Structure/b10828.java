package chap00_Data_Structure;

import java.util.Scanner;
import java.util.Stack;

public class b10828 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String order;
        while(input-- > 0) {
            order = sc.next();
            switch (order) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? "-1" : stack.peek()).append("\n");
            }
        }
        sc.close();
        System.out.print(sb);
    }
}
