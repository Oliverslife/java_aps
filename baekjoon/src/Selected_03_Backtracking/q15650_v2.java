package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q15650_v2 {
    static int n, m;
    static int[] ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int depth) {
        if(depth == m) {                        //m개가 모두 선택되었다면
            for(int x : ans) {                  //ans에 담긴 답안을 StringBuilder에 쌓기
                sb.append(x + " ");
            }
            sb.append("\n");                    //다음 답안을 받기 위해 개행
            return;                             //작업 완료 후 종료
        }

        for(int i=0; i<n; i++) {                //n까지 순회하면서
            if(!visited[i]) {                   //중복되지 않았다면
                visited[i] = true;              //방문했음을 표기한 후
                ans[depth] = i + 1;             //depth번 째의 답안에 i + 1 입력 (1부터 n까지 순회해야 하나 인덱스 매칭으로 인해 0부터 n-1까지 순회하기에 보정해 줌)
                dfs(depth + 1);           //다음 칸(depth + 1)의 답안을 찾기위해 재귀호출
                for(int j=i+1; j<n; j++)
                    visited[j] = false;         //depth = 1의 탐색 진행을 위해 최종선택에 사용된 방문여부를 초기화시켜줌
            }
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
        dfs(0);                           //depth = 0 부터 시작
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
