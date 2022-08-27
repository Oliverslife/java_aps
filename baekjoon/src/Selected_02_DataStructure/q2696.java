package Selected_02_DataStructure;

import java.io.*;
import java.util.*;

public class q2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q1, q2;

        int M, checker, tmp;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            q1 = new PriorityQueue<>();
            q2 = new PriorityQueue<>(Collections.reverseOrder());
            checker = 0;

            M = Integer.parseInt(br.readLine());
            sb.append((M + 1) / 2).append("\n");

            for(int i=0; i<M; i++) {
                if(i % 10 == 0)
                    st = new StringTokenizer(br.readLine());
                tmp = Integer.parseInt(st.nextToken());

                if(i % 2 == 0)
                    q2.offer(tmp);
                else
                    q1.offer(tmp);

                if(q1.size() * q2.size() != 0 && q2.peek() > q1.peek()) {
                    q2.offer(q1.poll());
                    q1.offer(q2.poll());
                }

                if(i % 2 == 0) {
                    if(checker == 9 || i == M - 1) {
                        sb.append(q2.peek() + "\n");
                        checker = 0;
                    }
                    else
                        sb.append(q2.peek() + " ");
                    checker++;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
