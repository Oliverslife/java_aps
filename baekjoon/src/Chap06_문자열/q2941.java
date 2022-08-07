package Chap06_문자열;

import java.io.*;

public class q2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] target = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String str = br.readLine();
        for(String x : target) {
            str = str.replace(x, "X");
        }
        bw.write(String.valueOf(str.length()));
        bw.flush();
        bw.close();
        br.close();
    }
}
