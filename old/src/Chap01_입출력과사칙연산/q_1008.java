package Chap01_입출력과사칙연산;

import java.util.*;
import java.io.*;

public class q_1008 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        bw.write(String.format("%.9f", A/B));
        bw.flush();
        bw.close();
        br.close();
    }
}