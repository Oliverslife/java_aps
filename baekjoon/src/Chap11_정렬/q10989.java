package Chap11_정렬;

import java.io.*;

public class q10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];
        for(int i=0; i<n; i++) {
            cnt[Integer.parseInt(br.readLine())]++;
        }
        for(int i=1; i<10001; i++) {
            while(cnt[i]>0) {
                sb.append(i).append("\n");
                cnt[i]--;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
