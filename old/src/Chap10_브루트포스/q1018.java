package Chap10_브루트포스;

import java.io.*;
import java.util.StringTokenizer;

public class q1018 {
    static String[] map;
    static int chess(int i, int j) {
        String[] answer = {"WBWBWBWB", "BWBWBWBW"};
        int tmp = 0;
        int r;
        int c;
        for(int x=0; x<8; x++) {
            r = i + x;
            for(int y=0; y<8; y++) {
                c = j + y;
                if(map[r].charAt(c) != answer[r % 2].charAt(y))
                    tmp++;
            }
        }
        return Math.min(tmp, 64 - tmp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new String[M];
        for(int i=0; i<M; i++)
            map[i] = br.readLine();

        int ans = Integer.MAX_VALUE;
        int check;
        for(int i=0; i<M-7; i++) {
            for(int j=0; j<N-7; j++) {
                check = chess(i, j);
                if(ans > check)
                    ans = check;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
