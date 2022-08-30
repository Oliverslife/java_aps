package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q11868 {//https://librewiki.net/index.php?curid=40330
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cal = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens())
            cal ^= Integer.parseInt(st.nextToken());

        String ans = cal == 0 ? "cubelover" : "koosaga";
        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }
}
