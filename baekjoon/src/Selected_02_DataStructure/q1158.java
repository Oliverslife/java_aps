package Selected_02_DataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n; i++)
            q.offer(i);

        sb.append("<");
        while(!q.isEmpty()) {
            for(int i=0; i<k - 1; i++)
                q.offer(q.poll());
            sb.append(q.poll() + ", ");
        }

        bw.write(sb.substring(0, sb.length()-2) + ">");
        bw.flush();
        bw.close();
        br.close();
    }
}
