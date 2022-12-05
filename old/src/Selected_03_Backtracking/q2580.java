package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q2580 {
    static int[][] map = new int[9][9];
    static StringBuilder sb = new StringBuilder();

    static boolean check(int r, int c, int target) {
        for(int i=0; i<9; i++)      //가로 중복확인
            if(map[r][i] == target)
                return false;

        for(int i=0; i<9; i++)      //세로 중복확인
            if(map[i][c] == target)
                return false;

        int tr = r / 3 * 3;   //부분 정사각형 중복확인
        int tc = c / 3 * 3;
        for(int i=tr; i<tr + 3; i++)
            for(int j=tc; j<tc + 3; j++)
                if(map[i][j] == target)
                    return false;

        return true;
    }

    static void dfs(int r, int c) {
        if(r == 8 && c == 9) {      //조건을 만족시킨 최종 답안에 도달했을 때 출력해주어야 함. 다른 분기에서 수정이 일어남. 이 부분 다시 확인하기.
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++)
                    sb.append(map[i][j] + " ");
                sb.append("\n");
            }
            System.out.print(sb.toString());
            System.exit(0);                 //답이 여러가지인 경우 전부 출력된다...
            return;
        }

        r += c == 9 ? 1 : 0;
        c -= c == 9 ? 9 : 0;

        if(map[r][c] == 0) {
            for(int i=1; i<=9; i++) {   //1 ~ 9 범위의 수 중에서
                if(check(r, c, i)) {    //조건에 맞는 값을 대입
                    map[r][c] = i;      //i를 대입한 경우
                    dfs(r, c+1);     //분기를 만들어 탐색 진행
                }
            }
            map[r][c] = 0;          //위의 반복문에서 조건에 맞는 값을 대입할 수 없는 경우 (for문 내부의 재귀함수로 진입하지 못한 경우)
            return;                 //check에 미달하기에 해당 분기는 종료, 다른 분기에서 탐색 진행 (백트래킹의 가지치기)
        }
        dfs(r, c+1);                 //값이 0이 아니면 계속 진행
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
        br.close();

    }
}
