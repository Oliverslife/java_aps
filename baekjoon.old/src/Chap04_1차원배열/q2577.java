package Chap04_1차원배열;

import java.io.*;

public class q2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String str = Integer.toString(a*b*c);
        int[] cnt = new int[10];

        for (char ch : str.toCharArray()) {
            cnt[Character.getNumericValue(ch)]++;
        }

        for (int i=0; i<10; i++) {
            bw.write(String.valueOf(cnt[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}