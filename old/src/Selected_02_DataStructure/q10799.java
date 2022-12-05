package Selected_02_DataStructure;

import java.io.*;
import java.util.Stack;

public class q10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        String target = br.readLine();
        for(int i=0; i<target.length(); i++) {
            if(target.charAt(i) == '(')
                stack.push(i);
            else {
                if(stack.pop() == i-1)
                    ans += stack.size();
                else
                    ans += 1;
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
