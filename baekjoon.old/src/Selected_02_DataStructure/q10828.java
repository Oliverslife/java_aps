package Selected_02_DataStructure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class q10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String order;
        int tmp;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            switch (order) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(stack.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "top":
                    if(stack.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(stack.peek()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
