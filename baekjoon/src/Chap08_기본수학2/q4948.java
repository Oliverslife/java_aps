package Chap08_기본수학2;

import java.io.*;

public class q4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] sosu;
        int cnt;
        int n;

        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            cnt = 0;
            sosu = new boolean[(2*n)+1];
            sosu[0] = sosu[1] = true;

            //소수찾기, false로 남는 것들이 소수
            for(int i=2; i*i<= 2*n; i++) {
                if(sosu[i])
                    continue;
                for(int j=i*2; j<=2*n; j+=i)
                    sosu[j] = true;
            }

            //소수 개수찾기
            for(int i=n+1; i<=2*n; i++) {
                if(!sosu[i]) {
                    cnt++;
                }
            }
            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
