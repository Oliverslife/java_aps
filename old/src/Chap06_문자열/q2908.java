package Chap06_문자열;

import java.io.*;
import java.util.StringTokenizer;

public class q2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = ((a % 10) * 100) + (((a / 10) % 10) * 10) + a / 100;
        int d = ((b % 10) * 100) + (((b / 10) % 10) * 10) + b / 100;
        bw.write(String.valueOf(Math.max(c, d)));
        bw.flush();
        bw.close();
        br.close();
    }
}
