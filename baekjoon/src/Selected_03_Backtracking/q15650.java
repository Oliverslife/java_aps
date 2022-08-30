package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q15650 {
    static int n, m;
    static int[] ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int depth, int start) {
        if(depth == m) {                        //m개가 모두 선택되었다면
            for(int x : ans) {                  //ans에 담긴 답안을 StringBuilder에 쌓기
                sb.append(x + " ");
            }
            sb.append("\n");                    //다음 답안을 받기 위해 개행
            return;                             //작업 완료 후 종료
        }

        for(int i=start; i<n; i++) {            //매개변수로 전달받은 start부터 n까지 순회하면서
            ans[depth] = i + 1;                 //숫자를 담은 후
            dfs(depth + 1, i + 1);   //다음 숫자를 고를 때의 시작 위치를 보정해 줌
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //n까지의 값 중
        m = Integer.parseInt(st.nextToken());   //m개를 선택 (정답의 길이. 즉, depth에 해당)
        ans = new int[m];                       //m개를 선택한 답안을 '임시'로 담을 배열
        visited = new boolean[n];               //dfs 탐색 중 중복여부를 확인하기 위한 배열
        dfs(0, 0);                   //depth = 0 부터 시작
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
