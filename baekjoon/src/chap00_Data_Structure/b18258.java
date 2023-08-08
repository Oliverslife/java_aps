package chap00_Data_Structure;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b18258 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int input = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while(input-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(deque.isEmpty() ? "-1" : deque.poll()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? "-1" : deque.peek()).append("\n");
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
