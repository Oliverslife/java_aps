package Chap13_기하1;

import java.io.*;
import java.util.StringTokenizer;

public class q1358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int r = h / 2;
        int ans = 0, xtmp, ytmp;
        double st_dis, end_dis;

        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            xtmp = Integer.parseInt(st.nextToken());
            ytmp = Integer.parseInt(st.nextToken());

            st_dis = Math.sqrt(Math.pow(x - xtmp, 2) + Math.pow(y + r - ytmp, 2));
            end_dis = Math.sqrt(Math.pow(x + w - xtmp, 2) + Math.pow(y + r - ytmp, 2));
            if((x <= xtmp && xtmp <= x + w && y <= ytmp && ytmp <= y + h) || st_dis <= r || end_dis <= r)
                ans++;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
