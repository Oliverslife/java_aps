package SSAFY_IM준비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q2615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int r, c, cnt, ansx = 0, ansy = 0, ans = 0;
        //아래로, 우측으로, 대각선으로 > 좌하향이 아닌 우상향으로 탐색하는 이유 : 가장 왼쪽의 좌표를 반환해야 하기 때문.
        int[] dr = {1, 0, -1, 1};
        int[] dc = {0, 1, 1, 1};

        int[][] map = new int[21][21];
        for(int i=1; i<20; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<20; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        loop:
        for(int i=1; i<20; i++)
            for(int j=1; j<20; j++)
                if(map[i][j] != 0)
                    for(int k=0; k<4; k++) {
                        r = i;
                        c = j;
                        cnt = 1;
                        while(r+dr[k] < 20 && r+dr[k] >= 1 && c+dc[k] < 20 && c+dc[k] >= 1 && map[r+dr[k]][c+dc[k]] == map[i][j]) {
                            cnt++;
                            r += dr[k];
                            c += dc[k];
                            if(cnt == 5 && map[i-dr[k]][j-dc[k]] != map[i][j] && map[r+dr[k]][c+dc[k]] != map[i][j]) {
                                ansx = i;
                                ansy = j;
                                ans = map[i][j];
                                break loop;
                            }
                        }
                    }


        sb.append(ans + "\n");
        if(ans != 0)
            sb.append(ansx + " " + ansy);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}