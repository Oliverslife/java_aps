package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class s2112_solving {

    static int d, w, k, ans;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++) {

            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            map = new int[d][w];
            for(int i=0; i<d; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }



        }
    }
}
