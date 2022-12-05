package Chap01_입출력과사칙연산;

import java.util.*;
import java.io.*;

public class q_10998 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        bw.write(String.format("%d", A * B));
        bw.flush();
        bw.close();
        br.close();
    }
}
