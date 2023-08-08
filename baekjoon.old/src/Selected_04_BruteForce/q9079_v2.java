package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class q9079_v2 {
    static int ans;
    static boolean[] visited;
    static boolean[][] map;
    static boolean sameCheck() {
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(map[i][j] != map[0][0])
                    return false;
        return true;

    }

    private static void swap(int i) {
        if(i<3) {//행 뒤집기
            for(int j=0;j<3;j++) {
                map[i][j] = !map[i][j];
            }
        }else if(i<6) {//열 뒤집기
            for(int j=0;j<3;j++) {
                map[j][i-3] = !map[j][i-3];
            }
        }else if(i==6){// \대각 뒤집기
            for(int j=0;j<3;j++) {
                map[j][j] = !map[j][j];
            }
        }else {// /대각 뒤집기
            for(int j=0;j<3;j++) {
                map[j][2-j] = !map[j][2-j];
            }
        }

    }
    static void dfs(int depth) {
        if(sameCheck()) {
            ans = Math.min(ans, depth);
            return;
        }
        if(depth == 8)
            return;

        for(int i=0;i<8;i++) {
            if(!visited[i]) {
                visited[i]=true;
                swap(i);
                dfs(depth+1);
                visited[i]=false;
                swap(i);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            ans = Integer.MAX_VALUE;
            visited = new boolean[8];   //swap하는 방법의 수
            map = new boolean[3][3];
            for(int i=0; i<3; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++)
                    map[i][j] = st.nextToken().equals("H") ? true : false;
            }

            dfs(0);

            ans = ans == Integer.MAX_VALUE ? -1 : ans;
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
