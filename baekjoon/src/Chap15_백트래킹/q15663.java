package Chap15_백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class q15663 {

    static int n, m;
    static int[] arr;
    static int[] ansbox;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Set<String> filter = new LinkedHashSet<>();

    static void check(int depth) {
        if(depth == m) {
            for(int x : ansbox) {
                sb.append(x + " ");
            }
            filter.add(sb.toString());
            sb.setLength(0);
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ansbox[depth] = arr[i];
                check(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> ans = new ArrayList<>();

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

        check(0);

        for(String str : filter)
            sb.append(str + "\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}