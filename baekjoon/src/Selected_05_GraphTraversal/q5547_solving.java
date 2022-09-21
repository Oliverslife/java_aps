package Selected_05_GraphTraversal;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q5547_solving {

    static int w, h;

    static boolean is_in(int r, int c) {
        return (r >= 0 && r < h+2 && c >= 0 && c < w+2) ? true : false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] o_drc = { {0, -1}, {0, 1}, {1, 0}, {1, 1}, {-1, 0}, {-1, 1} };      //홀수 번 째 줄의 탐색범위
        int[][] e_drc = { {0, -1}, {0, 1}, {1, -1}, {1, 0}, {-1, -1}, {-1, 0} };    //짝수 번 째 줄의 탐색범위
        int[][] drc = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[][] map = new int[h+2][w+2];
        boolean[][] visited = new boolean[h+2][w+2];

        int cnt;
        for(int i=1; i<=h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=w; j++) {
                cnt = Integer.parseInt(st.nextToken());
                map[i][j] = cnt;
                if(cnt == 1)
                    visited[i][j] = true;
            }
        }

        boolean[][] origin = visited;   //건물에 visited 처리한 배열.

        // 일단 건물 내부공간을 좀 구분해야겠다.

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        visited[0][0] = true;

        int tr, tc;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            map[tmp[0]][tmp[1]] = 5;        //바깥 공간을 2로 채우면서 구분해줌

            for(int i=0; i<4; i++) {
                tr = tmp[0] + drc[i][0];
                tc = tmp[1] + drc[i][1];

                if(is_in(tr, tc) && !visited[tr][tc]) {
                    visited[tr][tc] = true;
                    q.offer(new int[] {tr, tc});
                }
            }
        }

//        for(int i=0; i<h+2; i++) {
//            for (int j = 0; j < w + 2; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        visited = origin;
        q.offer(new int[] {0, 0});
        visited[0][0] = true;

        cnt = 0;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();

            for(int i=0; i<6; i++) {            //외벽 확인
                if(tmp[1] % 2 == 1) {
                    tr = tmp[0] + o_drc[i][0];
                    tc = tmp[1] = o_drc[i][1];
                }
                else {
                    tr = tmp[0] + e_drc[i][0];
                    tc = tmp[1] = e_drc[i][1];
                }
                cnt += is_in(tr, tc) && map[tr][tc] == 1 ? 1 : 0;

            }

            for(int i=0; i<4; i++) {
                tr = tmp[0] + drc[i][0];
                tc = tmp[1] + drc[i][1];

                if(is_in(tr, tc) && !visited[tr][tc] && map[tr][tc] == 2) {
                    visited[tr][tc] = true;
                    q.offer(new int[] {tr, tc});
                }
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
