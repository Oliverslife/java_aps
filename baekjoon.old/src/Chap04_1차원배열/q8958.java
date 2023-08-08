package Chap04_1차원배열;

import java.io.*;

public class q8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans;
        int bonus;

        int n = Integer.parseInt(br.readLine());
        String target;
        for(int i=0; i<n; i++) {
            ans = 0;
            bonus = 0;
            for(byte x : br.readLine().getBytes()) {
                if(x == 'O') {
                    ans += 1 + bonus++;
                }
                else
                    bonus = 0;
            }
            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
