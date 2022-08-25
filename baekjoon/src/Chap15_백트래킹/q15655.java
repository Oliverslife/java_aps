package Chap15_백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q15655 {

    static int n, m;
    static int[] arr;
    static int[] ansbox;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void check(int depth, int start) {
        if(depth == m) {
            for(int x : ansbox) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<n; i++) {
            ansbox[depth] = arr[i];
            check(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ansbox = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        check(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
