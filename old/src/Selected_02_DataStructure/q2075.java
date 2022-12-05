package Selected_02_DataStructure;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                q.offer(Integer.parseInt(st.nextToken()));
        }
        for(int i=1; i<N; i++)
            q.poll();

        bw.write(q.poll() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
