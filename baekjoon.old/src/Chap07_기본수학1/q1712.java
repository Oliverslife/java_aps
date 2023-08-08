package Chap07_기본수학1;

import java.io.*;
import java.util.StringTokenizer;

public class q1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d;

        if(c - b <= 0)
            d = -1;
        else
            d = (a / (c - b)) + 1;

        bw.write(String.valueOf(d));
        bw.flush();
        bw.close();
        br.close();
    }
}
