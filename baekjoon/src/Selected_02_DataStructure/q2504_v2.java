package Selected_02_DataStructure;

import java.io.*;
import java.util.Stack;

public class q2504_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int tmp = 1, ans = 0;
        char checker = '\0';

        String target = br.readLine();
        for(int i=0; i<target.length(); i++) {
            char ch = target.charAt(i);
            if(ch == '(' || ch == '[') {
                stack.push(i);
                tmp *= ch == '(' ? 2 : 3;
                checker = ch == '(' ? ')' : ']';
            }
            else {
                if(stack.isEmpty() || checker != ch) {
                    ans = 0;
                    break;
                }
                else if(stack.pop() == i-1)
                    ans += tmp;
                checker = !stack.isEmpty() ? (target.charAt(stack.peek()) == '(' ? ')' : ']') : '\0';
                tmp /= ch == ')' ? 2 : 3;
            }
        }
        if(!stack.isEmpty())
            ans = 0;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}