package Chap07_기본수학1;

import java.io.*;

public class q_2839 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(br.readLine());
        int ans = 0;
        while(true) {
            if(target % 5 == 0) {
                ans += (target / 5);
                break;
            }
            else if(target < 0) {
                ans = -1;
                break;
            }
            target -= 3;
            ans++;
        }
        bw.write(String.format("%d", ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
