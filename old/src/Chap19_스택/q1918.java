package Chap19_스택;

import java.io.*;
import java.util.Stack;

public class q1918 {
    static int priority(char ch) {
        if(ch == '*' || ch == '/')
            return 2;
        else if(ch == '+' || ch == '-')
            return 1;
        else
            return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        String target = br.readLine();
        for(char ch : target.toCharArray()) {
            if(ch >= 'A' && ch <= 'Z')
                ans.append(ch + "");
            else {
                if(ch == '(')
                    stack.push(ch);
                else if(ch == ')') {
                    while(!stack.isEmpty() && stack.peek() != '(')
                        ans.append(stack.pop());
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else {
                    while(!stack.isEmpty() && priority(ch) <= priority(stack.peek()))
                        ans.append(stack.pop());
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty())
            ans.append(stack.pop());
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
