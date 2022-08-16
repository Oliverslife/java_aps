package SSAFY_IM준비;

import java.io.*;
import java.util.StringTokenizer;

public class q1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int a, b, tmpa, tmpb, checker = 0;

        int n = Integer.parseInt(br.readLine());
        boolean[] s = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            if(Integer.parseInt(st.nextToken()) == 1)
                s[i] = true;

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a == 1) {
                for(int j=0; j<n; j++)
                    if((j+1) % b == 0)
                        s[j] = !s[j];
            }
            else {
                s[b-1] = !s[b-1];
                tmpa = b-2;
                tmpb = b;
                while(tmpa >= 0 && tmpb < n && s[tmpa] == s[tmpb]) {
                    s[tmpa] = !s[tmpa];
                    s[tmpb] = !s[tmpb];
                    tmpa--;
                    tmpb++;
                }
            }
        }

        for(boolean ans : s) {
            if(ans)
                sb.append("1 ");
            else
                sb.append("0 ");
            checker++;
            if(checker == 20) {
                checker = 0;
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
