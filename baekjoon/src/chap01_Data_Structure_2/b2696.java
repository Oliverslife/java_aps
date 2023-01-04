package chap01_Data_Structure_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b2696 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        int M, cnt;
        while(T-- > 0) {

            cnt = 0;
            M = Integer.parseInt(br.readLine());
            sb.append(M / 2 + 1).append("\n");
            for(int i=0; i<M; i++) {
                if(i % 10 == 0)
                    st = new StringTokenizer(br.readLine());

                if(i % 2 == 0) {    //홀수
                    pq2.offer(Integer.parseInt(st.nextToken()));

                    if(!pq1.isEmpty() && pq1.peek() >= pq2.peek()) {
                        pq2.offer(pq1.poll());
                        pq1.offer(pq2.poll());
                    }

                    if(cnt == 10) {
                        sb.append("\n");
                        cnt = 0;
                    }
                    sb.append(pq2.peek() + " ");
                    cnt++;

                }
                else
                    pq1.offer(Integer.parseInt(st.nextToken()));
            }

            sb.append("\n");

            pq1.clear();
            pq2.clear();
        }

        System.out.println(sb);

    }
}

