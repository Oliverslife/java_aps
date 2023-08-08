package ETC;

import java.io.*;

public class q1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] dr = {1, 0, -1, 0};   //하 우 상 좌
        int[] dc = {0, 1, 0, -1};

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int num = N * N, r = 0, c = 0, idx = 0, x = 0, y = 0;
        while(true) {

            if(num == target) {
                x = r + 1;
                y = c + 1;
            }

            map[r][c] = num--;

            if(num == 0)
                break;

            if(r+dr[idx] >= 0 && r+dr[idx] < N && c+dc[idx] >= 0 && c+dc[idx] < N && map[r+dr[idx]][c+dc[idx]] == 0) {
                r += dr[idx];
                c += dc[idx];
            }
            else {
                idx += idx != 3 ? 1 : -3;
                num++;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                sb.append(map[i][j] + " ");
            sb.append("\n");
        }
        sb.append(x + " " + y);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
