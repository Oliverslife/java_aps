package SSAFY_IM준비;

import java.io.*;
import java.util.StringTokenizer;

public class q2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<4; i++) {

            String ans = "";

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sq1_x1 = Integer.parseInt(st.nextToken());  //좌하단
            int sq1_y1 = Integer.parseInt(st.nextToken());
            int sq1_x2 = Integer.parseInt(st.nextToken());  //우상단
            int sq1_y2 = Integer.parseInt(st.nextToken());

            int sq2_x1 = Integer.parseInt(st.nextToken());  //좌하단
            int sq2_y1 = Integer.parseInt(st.nextToken());
            int sq2_x2 = Integer.parseInt(st.nextToken());  //우상단
            int sq2_y2 = Integer.parseInt(st.nextToken());

            if (sq1_x2 < sq2_x1 || sq1_y2 < sq2_y1 || sq2_x2 < sq1_x1 || sq2_y2 < sq1_y1)
                ans = "d\n";
            else if ((sq1_x1 == sq2_x2 && sq1_y1 == sq2_y2) || (sq1_x1 == sq2_x2 && sq1_y2 == sq2_y1) || (sq1_x2 == sq2_x1 && sq1_y2 == sq2_y1) || (sq1_x2 == sq2_x1 && sq1_y1 == sq2_y2))
                ans = "c\n";
            else if (sq1_x2 == sq2_x1 || sq1_y2 == sq2_y1|| sq2_x2 == sq1_x1 || sq1_y1 == sq2_y2)
                ans = "b\n";
            else
                ans = "a\n";

            bw.write(ans);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
