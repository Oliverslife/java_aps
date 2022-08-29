package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q20499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "/");
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        String ans = (k + a < d || d == 0) ? "hasu" : "gosu";
        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }
}
