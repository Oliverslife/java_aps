package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        p += t % (w * 2);
        if(p > w)
            p = Math.abs(w * 2 - p);
        q += t % (h * 2);
        if(q > h)
            q = Math.abs(h * 2 - q);

        bw.write(p + " " + q);
        bw.flush();
        bw.close();
        br.close();
    }
}
