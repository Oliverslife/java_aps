package Chap08_기본수학2;

import java.io.*;
import java.util.StringTokenizer;

public class q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());    //사용하지 않음
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean is_sosu;
        int ans = 0;

        while (st.hasMoreTokens()) {
            is_sosu = true;
            int target = Integer.parseInt(st.nextToken());
            if(target == 1)
                continue;

            for(int i=2; i*i<=target; i++) {
                if(target % i == 0) {
                    is_sosu = false;
                    break;
                }
            }
            if(is_sosu)
                ans++;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
