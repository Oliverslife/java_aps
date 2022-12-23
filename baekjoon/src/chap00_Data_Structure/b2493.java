package chap00_Data_Structure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class b2493 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Stack<Integer> index = new Stack<>();
        Stack<Integer> height = new Stack<>();
        height.push(0);
        index.push(0);

        for(int i=0; i<N; i++) {
            int target = Integer.parseInt(st.nextToken());
            while(!height.isEmpty() && height.peek() < target) {
                index.pop();
                height.pop();
            }
            sb.append(height.isEmpty() ? 0 : index.peek()).append(" ");
            height.push(target);
            index.push(i + 1);
        }
        sb.setLength(sb.length() - 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
