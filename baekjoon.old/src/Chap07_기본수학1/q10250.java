package Chap07_기본수학1;

import java.io.*;
import java.util.StringTokenizer;

public class q10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int y;
        int x;

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            y = n % h == 0 ? h : n % h;         //층 계산
            x = y == h ? n / h : (n / h) + 1;   //호 계산

            bw.write(String.format("%d%02d", y, x));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
