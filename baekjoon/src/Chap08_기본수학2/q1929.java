package Chap08_기본수학2;

import java.io.*;
import java.util.StringTokenizer;

public class q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] sosu = new boolean[n+1];
        sosu[0] = sosu[1] = true;

        //소수찾기, false로 남는 것들이 소수
        for(int i=2; i*i<= n; i++) {
            if(sosu[i])
                continue;
            for(int j=i*2; j<n+1; j+=i)
                sosu[j] = true;
        }

        for(int i=m; i<=n; i++) {
            if(!sosu[i]) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
