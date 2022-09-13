package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class q17136 {

    static int ans = Integer.MAX_VALUE;
    static int[] confetti = {5, 5, 5, 5, 5};
    static boolean[][] map = new boolean[10][10];

    static void swap(int r, int c, int size) {
        for(int i=r; i<r+size+1; i++)
            for(int j=c; j<c+size+1; j++)
                map[i][j] = !map[i][j];
    }

    static boolean stickable(int r, int c, int size) {
        for(int i=r; i<r+size+1; i++)
            for(int j=c; j<c+size+1; j++)
                if(i>9 || j>9 || !map[i][j])
                    return false;
        return true;
    }

    static void dfs(int r, int c, int used) {

        if(used >= ans)      //기록된 값보다 같거나 많은 색종이를 사용하면 가지치기
            return;

        if((r == 9 && c == 10)) {
            ans = used;     //가지치기를 뚫고 살아남아 도달한 값이 기록됨
            return;
        }

        r += c == 10 ? 1 : 0;
        c -= c == 10 ? 10 : 0;

        if(map[r][c]) {     //1이면 탐색
            for(int i=4; i>=0; i--)     //큰 색종이부터
                if(confetti[i] > 0 && stickable(r, c, i)) {     //색종이가 남아있고 붙일 수 있다면
                    swap(r, c, i);
                    confetti[i]--;      //색종이 붙였을 경우
                    dfs(r, c+1, used + 1);
                    confetti[i]++;      //색종이를 안붙였을 경우
                    swap(r, c, i);
                }
        }
        else {      //0이면 그대로 진행
            dfs(r, c+1, used);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++)
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
        }

        dfs(0, 0, 0);

        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
