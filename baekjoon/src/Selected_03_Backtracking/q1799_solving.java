package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q1799_solving {//시간초과
    static int n, ans = 0;
    static boolean[] d1, d2;
    static boolean[][] map;

    static void chess(int r, int c, int sum) {
        if(c == n) {
            c = 0;
            r++;
            chess(r, c, sum);
        }
        if(r == n) {
            ans = Math.max(ans, sum);
            return;
        }

        if(map[r][c] && !d1[r + c] && !d2[r - c + n - 1]) {
            d1[r+c] = true;
            d2[r-c+n-1] = true;
            chess(r, c + 1, sum + 1);
            d1[r+c] = false;
            d2[r-c+n-1] = false;
        }
        chess(r, c + 1, sum);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
        }
        d1 = new boolean[2*n - 1];	//x+y 확인
        d2 = new boolean[2*n - 1];	//x-y 확인
        chess(0, 0, 0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
