package Chap08_기본수학2;

import java.io.*;

public class q9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, a, b;
        boolean[] sosu;

        int t = Integer.parseInt(br.readLine());

        for(int x=0; x<t; x++) {
            n = Integer.parseInt(br.readLine());
            sosu = new boolean[n+1];

            //소수찾기, false로 남는 것들이 소수
            for(int i=2; i*i<= n; i++) {
                if(sosu[i])
                    continue;
                for(int j=i*2; j<=n; j+=i)
                    sosu[j] = true;
            }

            a = b = n / 2;
            for(int i=0; i<n/2; i++) {
                if(!sosu[a] && !sosu[b])
                    break;
                a--;
                b++;
            }

            bw.write(String.format("%d %d", a, b));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
