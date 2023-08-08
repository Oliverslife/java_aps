package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q1799 {
    static int n, ansB = 0, ansW = 0;
    static boolean[] d1, d2;
    static boolean[][] map;

    static void chessB(int r, int c, int sum) {
        if(r == n-1 && c > n-1) {
            ansB = Math.max(ansB, sum);
            return;
        }

        r += c > n-1 ? 1 : 0;
        c = c > n-1 ? n % 2 == 0 ? c == n ? 1 : 0 : c == n ? 0 : 1 : c;

        if(map[r][c] && !d1[r + c] && !d2[r - c + n - 1]) {
            d1[r+c] = true;
            d2[r-c+n-1] = true;
            chessB(r, c + 2, sum + 1);
            d1[r+c] = false;
            d2[r-c+n-1] = false;
        }
        chessB(r, c + 2, sum);
    }

    static void chessW(int r, int c, int sum) {
        if(r == n-1 && c > n-1) {
            ansW = Math.max(ansW, sum);
            return;
        }

        r += c > n-1 ? 1 : 0;
        c = c > n-1 ? n % 2 == 0 ? c == n ? 1 : 0 : c == n ? 0 : 1 : c;

        if(map[r][c] && !d1[r + c] && !d2[r - c + n - 1]) {
            d1[r+c] = true;
            d2[r-c+n-1] = true;
            chessW(r, c + 2, sum + 1);
            d1[r+c] = false;
            d2[r-c+n-1] = false;
        }
        chessW(r, c + 2, sum);
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
        chessB(0, 0, 0);
        chessW(0, 1, 0);
        int ans = ansB + ansW;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
