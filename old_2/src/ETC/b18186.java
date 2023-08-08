package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class b18186 {

    public static void main(String[] args) throws IOException {

        int N, B, C, idx = 0;
        long get2, get3, ans = 0;
        long[] factory;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        factory = new long[N+2];

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            factory[idx++] = Integer.parseInt(st.nextToken());

        if (B < C) {    // 단품 구매가 더 저렴한 경우
            for (int i=0; i<N; i++)
                ans += factory[i] * B;
        } else {        // 묶음 구매가 더 저렴한 경우
            for (int i=0; i<N; i++) {
                if (factory[i+1] > factory[i+2]) {
                    get2 = Math.min(factory[i], factory[i+1] - factory[i+2]);
                    factory[i] -= get2;
                    factory[i+1] -= get2;
                    ans += get2 * (B + C);

                    get3 = Math.min(factory[i], Math.min(factory[i+1], factory[i+2]));
                    factory[i] -= get3;
                    factory[i+1] -= get3;
                    factory[i+2] -= get3;
                    ans += get3 * (B + 2 * C);
                } else {
                    get3 = Math.min(factory[i], Math.min(factory[i+1], factory[i+2]));
                    factory[i] -= get3;
                    factory[i+1] -= get3;
                    factory[i+2] -= get3;
                    ans += get3 * (B + 2 * C);

                    get2 = Math.min(factory[i], factory[i+1]);
                    factory[i] -= get2;
                    factory[i+1] -= get2;
                    ans += get2 * (B + C);
                }
                ans += factory[i] * B;

            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
