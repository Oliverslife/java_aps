package Selected_02_DataStructure;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> d = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String order;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            switch (order) {
                case "push_front":
                    d.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    d.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(d.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(d.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if(d.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(d.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(d.size()).append("\n");
                    break;
                case "empty":
                    if(d.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "front":
                    if(d.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(d.peekFirst()).append("\n");
                    break;
                case "back":
                    if(d.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(d.peekLast()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}