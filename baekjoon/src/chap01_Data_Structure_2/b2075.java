package chap01_Data_Structure_2;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b2075 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                pq.offer(Integer.parseInt(st.nextToken()));
        }

        while(N-- != 1)
            pq.poll();

        bw.write(String.format("%d", pq.poll()));
        bw.flush();
        bw.close();
        br.close();
    }
}
