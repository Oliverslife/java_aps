package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q14888 {   //백트래킹 실력이 늘지 않아...

    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr, order = new int[4];

    static void dfs(int depth, int result) {
        if(depth == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for(int i=0; i<4; i++) {
            if(order[i] > 0) {
                order[i]--;
                if(i == 0)
                    dfs(depth + 1, result + arr[depth]);
                else if(i == 1)
                    dfs(depth + 1, result - arr[depth]);
                else if(i == 2)
                    dfs(depth + 1, result * arr[depth]);
                else
                    dfs(depth + 1, result / arr[depth]);
                order[i]++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            order[i] = Integer.parseInt(st.nextToken());
        dfs(1, arr[0]);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }
}
