package SSAFY_IM준비;

import java.io.*;

public class q2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String target = br.readLine().replaceAll("LL", "S");

        bw.write(Math.min(target.length() + 1, n) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
