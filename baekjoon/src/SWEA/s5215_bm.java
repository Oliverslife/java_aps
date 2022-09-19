package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class s5215_bm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] foods;
        int n, limit;

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());

            foods = new int[n][2];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                foods[i][0] = Integer.parseInt(st.nextToken());     //맛
                foods[i][1] = Integer.parseInt(st.nextToken());     //칼로리
            }

            int taste, cal, max = Integer.MIN_VALUE;
            for(int i=0; i< 1<<n; i++) {
                taste = 0;
                cal = 0;
                for(int j=0; j<n; j++) {
                    if((i & 1 << j) > 0) {
                        taste += foods[j][0];
                        cal += foods[j][1];
                        if(cal > limit) {
                            taste = 0;
                            break;
                        }
                    }
                }
                max = Math.max(max, taste);
            }
            bw.write(String.format("#%d %d\n", tc, max));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
