package Chap06_문자열;

import java.io.*;
import java.util.StringTokenizer;

public class q1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(String.valueOf(st.countTokens()));
        bw.flush();
        bw.close();
        br.close();
    }
}
