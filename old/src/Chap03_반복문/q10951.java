package Chap03_반복문;

import java.io.*;
import java.util.StringTokenizer;

public class q10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String is_exist;
        int a, b;

        while ((is_exist = br.readLine()) != null) {
            st = new StringTokenizer(is_exist);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            System.out.println(a + b);
        }
        br.close();
    }
}