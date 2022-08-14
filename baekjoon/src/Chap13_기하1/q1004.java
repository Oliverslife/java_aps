package Chap13_기하1;

import java.io.*;
import java.util.StringTokenizer;

public class q1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int st_x = Integer.parseInt(st.nextToken());
            int st_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            int ans = 0;
            int howmany = Integer.parseInt(br.readLine());

            for(int j=0; j<howmany; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean st_in = Math.sqrt(Math.pow(st_x - x, 2) + Math.pow(st_y - y, 2)) < r;
                boolean end_in = Math.sqrt(Math.pow(end_x - x, 2) + Math.pow(end_y - y, 2)) < r;
                if(!(st_in && end_in) && (st_in || end_in))
                    ans++;
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
