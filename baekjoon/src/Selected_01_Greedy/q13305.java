package Selected_01_Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class q13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        long ans = 0;
        long min = Long.MAX_VALUE;

        int n = Integer.parseInt(br.readLine());
        long[] dist = new long[n];
        long[] cost = new long[n];
        dist[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            ans += dist[i] * min;
            if(min >= cost[i])
                min = cost[i];
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
