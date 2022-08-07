package Chap06_문자열;

import java.io.*;
import java.util.StringTokenizer;

public class q2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int re;
        String target;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            sb.setLength(0);
            st = new StringTokenizer(br.readLine());
            re = Integer.parseInt(st.nextToken());
            target = st.nextToken();
            for(char ch : target.toCharArray()) {
                for(int j=0; j<re; j++) {
                    sb.append(ch);
                }
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
