package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q9466 {    //다시 풀어보기

    static int n, cnt;
    static int[] data;
    static boolean[] visited;
    static boolean[] end;

    static void dfs(int now) {
        visited[now] = true;
        int tmp = data[now];
        if(!visited[tmp]) dfs(tmp);
        if(!end[tmp]) {
            cnt++;
            while(tmp != now) {
                cnt++;
                tmp = data[tmp];
            }
        }
        end[now] = true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {

            cnt = 0;
            n = Integer.parseInt(br.readLine());
            data = new int[n];
            visited = new boolean[n];
            end = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                data[i] = Integer.parseInt(st.nextToken()) - 1;

            for(int i=0; i<n; i++)
                dfs(i);

            sb.append(n - cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
