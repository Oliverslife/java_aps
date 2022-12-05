package ETC;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String order;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            switch (order) {
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(q.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(q.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "front":
                    if(q.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(q.peek()).append("\n");
                    break;
                case "back":
                    if(q.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(q.peekLast()).append("\n");

            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
