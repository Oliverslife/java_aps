package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] cnt = new int[n];
        int ans = 0, now = 0;
        cnt[now] = 1;
        while(cnt[now] != m) {
            if(cnt[now] % 2 == 1)
                now += (now + l >= n) ? (l - n) : l;
            else
                now -= (now - l < 0) ? (l - n) : l;
            cnt[now]++;
            ans++;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
