package Chap10_브루트포스;

import java.io.*;

public class q1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int target = 665;

        while(n != cnt) {
            if(String.valueOf(++target).contains("666"))
                cnt++;
        }

        bw.write(String.valueOf(target));
        bw.flush();
        bw.close();
        br.close();
    }
}
