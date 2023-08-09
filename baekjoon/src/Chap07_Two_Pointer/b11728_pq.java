package Chap07_Two_Pointer;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 단순 정렬 풀이
 */
public class b11728_pq {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            pq.offer(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            pq.offer(Integer.parseInt(st.nextToken()));

        while (!pq.isEmpty())
            sb.append(pq.poll()).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}