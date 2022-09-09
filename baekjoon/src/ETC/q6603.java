package ETC;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q6603 {
    static int k;
    static int[] s, ansbox;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int depth) {
        if(depth == 6) {
            for(int x : ansbox)
                sb.append(x + " ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<k; i++) {
            if(!visited[i]) {
                ansbox[depth] = s[i];
                visited[i] = true;
                dfs(depth + 1);
                for(int j=i+1; j<k; j++)
                    visited[j] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        while(k != 0) {
            s = new int[k];
            ansbox = new int[6];
            visited = new boolean[k];

            for(int i=0; i<k; i++)
                s[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(s);

            dfs(0);
            sb.append("\n");

            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
