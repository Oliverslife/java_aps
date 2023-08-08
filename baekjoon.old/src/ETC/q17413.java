package ETC;

import java.io.*;
import java.util.Stack;

public class q17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean checker = false;

        String target = br.readLine();
        for(char ch : target.toCharArray()) {
            switch(ch) {
                case '<':
                    checker = true;
                    while(!stack.isEmpty())
                        sb.append(stack.pop());
                    sb.append("<");
                    break;
                case '>':
                    checker = false;
                    sb.append(">");
                    break;
                case ' ':
                    while(!stack.isEmpty())
                        sb.append(stack.pop());
                    sb.append(" ");
                    break;
                default:
                    if(checker)
                        sb.append(ch);
                    else
                        stack.push(ch);
            }
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
