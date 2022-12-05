package Chap10_브루트포스;

import java.io.*;

public class q2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int tmp;
        int sum;

        for(int i=0; i<n; i++) {
            tmp = i;
            sum = 0;

            while(tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if(sum + i == n) {
                ans = i;
                break;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
