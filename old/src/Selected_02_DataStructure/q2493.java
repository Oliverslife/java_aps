package Selected_02_DataStructure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class q2493 {
    static class Data {
        int idx, height;
        public Data(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Data> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int tmp;
        String str;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if(stack.isEmpty())
                sb.append("0 ");
            else if(stack.peek().height >= tmp)
                sb.append(stack.peek().idx + " ");
            else {
                while(!stack.isEmpty() && stack.peek().height < tmp)
                    stack.pop();
                str = stack.isEmpty() ? "0 " : stack.peek().idx + " ";
                sb.append(str);
            }
            stack.push(new Data(i, tmp));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
