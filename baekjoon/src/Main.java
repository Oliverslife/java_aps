import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * sliding window
 */
public class Main {

    public static int stoi(String str) { return Integer.parseInt(str); }
    public static void main(String[] args) throws IOException {

        int N, S, start = 0, end = 0, sum = 0, ans = Integer.MAX_VALUE;
        int[] arr;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];   // 마지막 값을 확인하기 위해 +1

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        while (end <= N) {
            if (sum >= S) ans = Math.min(ans, end - start);
            if (sum < S) sum += arr[end++];
            else sum -= arr[start++];
        }

        ans = ans == Integer.MAX_VALUE ? 0 : ans;

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}