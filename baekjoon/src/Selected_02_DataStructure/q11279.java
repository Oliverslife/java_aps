package Selected_02_DataStructure;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class q11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()), tmp;
        while(N-- > 0) {
            tmp = Integer.parseInt(br.readLine());
            if(tmp == 0)
                sb.append(q.size() == 0 ? "0\n" : q.poll() + "\n");
            else
                q.offer(tmp);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
