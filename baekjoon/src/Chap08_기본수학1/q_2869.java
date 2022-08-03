package Chap08_기본수학1;

import java.util.*;
import java.io.*;

public class q_2869 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int ans = (V-B)/(A-B);
        if((V-B)%(A-B) != 0)
            ans++;
        bw.write(String.format("%d", ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
