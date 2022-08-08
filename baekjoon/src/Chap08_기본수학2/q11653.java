package Chap08_기본수학2;

import java.io.*;

public class q11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=2; i*i<=n; i++) {                     //n에 3이 들어가면 for문에 못들어감
            while(n % i == 0) {
                bw.write(String.format("%d\n", i));
                n /= i;
            }
        }
        if(n != 1)
            bw.write(String.valueOf(n));                //못들어간 n을 출력해줌

        bw.flush();
        bw.close();
        br.close();
    }
}
