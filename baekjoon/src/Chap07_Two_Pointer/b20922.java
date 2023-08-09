package Chap07_Two_Pointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Two Pointer 풀이
 */
public class b20922 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] cnt = new int[100001];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int start = 0, end = 0, max = 0;

        while (end < N) {
            while (end < N && cnt[arr[end]] + 1 <= K)
                cnt[arr[end++]]++;
            max = Math.max(max, end - start);
            cnt[arr[start++]]--;
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();

    }
}