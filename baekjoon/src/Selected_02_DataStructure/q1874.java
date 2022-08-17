package Selected_02_DataStructure;

import java.io.*;
import java.util.Stack;

public class q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int tmp, now = 1;

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            tmp = Integer.parseInt(br.readLine());
            if(tmp >= now) {
                while(now <= tmp) {
                    stack.push(now++);
                    sb.append("+\n");
                }
            }
            else if(stack.isEmpty() || stack.peek() != tmp) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            stack.pop();
            sb.append("-\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
