package chap00_Data_Structure;

import java.util.Scanner;
import java.util.Stack;

public class b1935 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String target = sc.next();
        int[] match = new int[N];
        for(int i=0; i<N; i++)
            match[i] = sc.nextInt();
        sc.close();

        Stack<Double> stack = new Stack<>();
        for(char ch : target.toCharArray()) {
            if(ch >= 'A' && ch <= 'Z')
                stack.push((double)match[(ch - 'A')]);
            else {
                double b = stack.pop();
                double a = stack.pop();
                switch(ch) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
