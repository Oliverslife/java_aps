package Chap13_기하1;

import java.io.*;
import java.util.StringTokenizer;

public class q1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int ans;
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int dis = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if(x1 == x2 && y1 == y2 && r1 == r2)    //두 원이 겹침
                ans = -1;
            else if(dis > Math.pow(r1 + r2, 2))     //두 원이 멀리 떨어져 있어 접점이 없음
                ans = 0;
            else if(dis < Math.pow(r2 - r1, 2))     //큰 원안에 작은 원이 있지만 접점이 없음
                ans = 0;
            else if(dis == Math.pow(r2 - r1, 2))    //내접
                ans = 1;
            else if(dis == Math.pow(r1 + r2, 2))    //외접
                ans = 1;
            else
                ans = 2;

            bw.write(ans + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
