package Chap19_스택;

import java.io.*;
import java.util.Stack;

public class q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        String str;

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            stack.clear();
            str = br.readLine();
            for(char ch : str.toCharArray()) {
                if(ch == '(')
                    stack.push(ch);
                else if(stack.isEmpty() && ch == ')') {
                    stack.push(ch);
                    break;
                }
                else
                    stack.pop();
            }
            if(stack.isEmpty())
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
