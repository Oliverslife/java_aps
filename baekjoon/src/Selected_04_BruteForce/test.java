package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class test {
    static int n, k, ans = 0;
    static boolean[] visited = new boolean[26];
    static String[] data;
    static void dfs(int depth, int start) {
        if(depth == k) {
            int tmp = 0;
            for(int i=0; i<n; i++) {        //제시된 단어를 하나씩 확인
                boolean checker = true;
                for(int j=0; j<data[i].length(); j++)       //단어를 한 글자씩 확인
                    if(!visited[data[j].charAt(j) - 'a']) { //해당하는 글자를 배우지 않았다면
                        checker = false;    //단어를 읽을 수 없음
                        break;              //확인 종료
                    }
                if(checker)                 //단어를 읽을 수 있다면
                    tmp++;                  //읽을 수 있는 단어 추가
            }
            ans = Math.max(ans, tmp);       //해당 경우의 수에서 가장 많이 읽을 수 있는 단어의 수를 정답으로 기록
            return;
        }

        for(int i=start; i<26; i++)
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i);
                visited[i] = false;
            }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String tmp;

        n = Integer.parseInt(st.nextToken());
        data = new String[n];
        k = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            tmp = br.readLine();
            data[i] = tmp.substring(4, tmp.length()-4);
        }

        if(k < 5) {
            System.out.print(0);
            return;
        }
        else if(k >= 26) {
            System.out.print(n);
            return;
        }
        else {

            visited['a' - 'a'] = true;
            visited['c' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            k -= 5;

            dfs(0, 0);

            bw.write(ans + "");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}