package ETC;

import java.io.*;
import java.util.Arrays;

public class q2748 {
    static long[] arr;
    static long dp(int idx) {
        if(arr[idx] != -1)
            return arr[idx];

        return arr[idx] = dp(idx - 1) + dp(idx - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new long[n+1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;

        bw.write(dp(n) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
