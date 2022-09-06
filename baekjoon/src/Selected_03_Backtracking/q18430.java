package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q18430 {
    static int n, m, ans = Integer.MIN_VALUE;
    static int[][] material;
    static boolean[][] used;
    static boolean check1(int r, int c) {   // (r, c)를 중심으로 up-right 확인
        if(r-1 >= 0 && c+1 < m && !used[r-1][c] && !used[r][c] && !used[r][c+1])
            return true;
        return false;
    }
    static boolean check2(int r, int c) {   // (r, c)를 중심으로 right-down 확인
        if(c+1 < m && r+1 < n && !used[r][c+1] && !used[r][c] && !used[r+1][c])
            return true;
        return false;
    }
    static boolean check3(int r, int c) {   // (r, c)를 중심으로 down-left 확인
        if(r+1 < n && c-1 >=0 && !used[r+1][c] && !used[r][c] && !used[r][c-1])
            return true;
        return false;
    }
    static boolean check4(int r, int c) {   // (r, c)를 중심으로 left-up 확인
        if(c-1 >=0 && r-1 >=0 && !used[r][c-1] && !used[r][c] && !used[r-1][c])
            return true;
        return false;
    }
    static void dfs(int r, int c, int sum) {
        if(r == n-1 && c == m) {    //c == m-1 인 경우까지 탐색이 완료되어야 하기 때문에 c == m인 경우에 종료
            ans = Math.max(ans, sum);
            return;
        }

        r += c == m ? 1 : 0;
        c -= c == m ? m : 0;

        if(check1(r, c)) {
            used[r-1][c] = used[r][c] = used[r][c+1] = true;
            dfs(r, c+1, sum + (material[r-1][c] + (2 * material[r][c]) + material[r][c+1]));
            used[r-1][c] = used[r][c] = used[r][c+1] = false;
        }
        if(check2(r, c)) {
            used[r][c+1] = used[r][c] = used[r+1][c] = true;
            dfs(r, c+1, sum + (material[r][c+1] + (2 * material[r][c]) + material[r+1][c]));
            used[r][c+1] = used[r][c] = used[r+1][c] = false;
        }
        if(check3(r, c)) {
            used[r+1][c] = used[r][c] = used[r][c-1] = true;
            dfs(r, c+1, sum + (material[r+1][c] + (2 * material[r][c]) + material[r][c-1]));
            used[r+1][c] = used[r][c] = used[r][c-1] = false;
        }
        if(check4(r, c)) {
            used[r][c-1] = used[r][c] = used[r-1][c] = true;
            dfs(r, c+1, sum + (material[r][c-1] + (2 * material[r][c]) + material[r-1][c]));
            used[r][c-1] = used[r][c] = used[r-1][c] = false;
        }
        dfs(r, c+1, sum);
        return;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        used = new boolean[n][m];
        material = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                material[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
