package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] cake = new int[L];
        int[] cnt = new int[N+1];
        int P, K, max = 0, idx = 0, greedy = 0, gidx = 0;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            if(K-P+1 > greedy) {
                greedy = K-P+1;
                gidx = i;
            }
            for(int j=P-1; j<K; j++)
                if(cake[j] == 0) {
                    cake[j] = i;
                    cnt[i]++;
                }
            if(cnt[i] > max) {
                max = cnt[i];
                idx = i;
            }
        }
        bw.write(gidx + "\n" + idx);
        bw.flush();
        bw.close();
        br.close();
    }
}
