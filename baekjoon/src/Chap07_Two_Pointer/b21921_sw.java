package Chap07_Two_Pointer;

/**
 * Sliding Window 풀이
 */
import java.io.*;
import java.util.StringTokenizer;

public class b21921_sw {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int tmp = 0;
        for (int i=0; i<X; i++)
            tmp += arr[i];

        int max = tmp, idx = 0, cnt = 1;
        for (int i=X; i<N; i++) {
            tmp += arr[i] - arr[idx++];
            cnt += max == tmp ? 1 : max < tmp ? 1 - cnt : 0;
            max = Math.max(max, tmp);
        }

        sb.append(max == 0 ? "SAD" : max + "\n" + cnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}