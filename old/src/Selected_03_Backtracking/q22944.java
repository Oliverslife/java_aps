package Selected_03_Backtracking;

import java.io.*;
import java.util.*;

public class q22944 {
    static int s_x, s_y, u_x, u_y, e_x, e_y, ans, n, h, d;
    static boolean[] visited;
    static char[][] map;
    static List<int[]> list;
    static void dfs(int via, int hp, int us, int r, int c) {
        int nowToSafe = Math.abs(r - e_x) + Math.abs(c - e_y);
        if(nowToSafe <= hp + us) {
            ans = Math.min(ans, nowToSafe + via);
            return;
        }

        for(int i=0; i<list.size(); i++) {
            int nowToWoosan = Math.abs(list.get(i)[0] - r) + Math.abs(list.get(i)[1] - c);
            if(hp + us < nowToWoosan || visited[i])
                continue;
            if(us < nowToWoosan) {
                visited[i] = true;
                dfs(via + nowToWoosan, hp - (nowToWoosan - us), d, list.get(i)[0], list.get(i)[1]);
                visited[i] = false;
            }
            else {
                visited[i] = true;
                dfs(via + nowToWoosan, hp, d, list.get(i)[0], list.get(i)[1]);
                visited[i] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new char[n][n];
        s_x = s_y = u_x = u_y = e_x = e_y = ans = 0;
        ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            String[] tokens = br.readLine().split("");
            for(int j=0; j<n; j++) {
                char ch = tokens[j].charAt(0);
                map[i][j] = ch;
                if(ch == 'S') {
                    s_x = i;
                    s_y = j;
                }
                else if(ch == 'U') {
                    int[] target = new int[] {i, j};
                    list.add(target);
                }
                else if(ch == 'E') {
                    e_x = i;
                    e_y = j;
                }
            }
        }
        visited = new boolean[list.size()];
        dfs(0, h, 0, s_x, s_y);
        ans = ans == Integer.MAX_VALUE ? -1 : ans;

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
