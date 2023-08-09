package Chap07_Two_Pointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Prefix Sum 풀이
 */
public class b21921_ps {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] sum = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int tmp = 0;
        for (int i=0; i<X; i++) {
            tmp += arr[i];
            sum[i] = tmp;
        }

        int max = tmp;
        for (int i=X; i<N; i++) {
            tmp -= arr[i-X];
            tmp += arr[i];
            sum[i] = tmp;
            max = Math.max(max, sum[i]);
        }

        int cnt = 0;
        for (int i=0; i<N; i++)
            cnt += max == sum[i] ? 1 : 0;

        sb.append(max == 0 ? "SAD" : max + "\n" + cnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}