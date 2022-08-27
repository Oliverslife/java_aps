package SSAFY_IM준비;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class q20440_v2 {
    static class Mosq implements Comparable<Mosq> {
        int start, end;
        public Mosq(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Mosq o) {
            if(this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new PriorityQueue<>();

        int start, end, cnt = 1;
        int N = Integer.parseInt(br.readLine());
        Mosq[] data = new Mosq[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            data[i] = new Mosq(start, end);
        }
        Arrays.sort(data);
        q.offer(data[0].end);
        start = data[0].start;
        end = data[0].end;

        for(int i=1; i<N; i++) {
            while(!q.isEmpty() && q.peek() < data[i].start)
                q.poll();
            if(!q.isEmpty() && q.peek() == data[i].start) {
                end = q.peek() == end ? data[i].end : end;
                q.poll();
            }
            q.offer(data[i].end);
            if(q.size() > cnt) {
                cnt = q.size();
                start = data[i].start;
                end = q.peek();
            }
        }
        sb.append(cnt).append("\n").append(start + " " + end);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
