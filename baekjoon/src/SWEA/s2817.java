package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class s2817 {

    static int n, k, ans;
    static int[] arr;
    static void check(int depth, int sum) {
        if(sum > k)
            return;
        else if(sum == k)
            ans++;
        for(int i=depth; i<n; i++)
            check(i+1, sum + arr[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++) {

            ans = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            check(0, 0);
            sb.append("#" + tc + " " + ans + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
