package Chap07_기본수학1;

import java.io.*;

public class q1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int row = 1;
        int head;
        int foot;
        int n = Integer.parseInt(br.readLine());

        while (n > row) {       //일단 몇 번째인지 찾기
            n -= row;
            row += 1;
        }                       //남은 n이 짝수면 좌하향, 홀수면 우상향
        if (row % 2 == 0) {
            head = n;
            foot = row - n + 1;
        }
        else {
            foot = n;
            head = row - n + 1;
        }
        bw.write(String.format("%d/%d", head, foot));
        bw.flush();
        bw.close();
        br.close();
    }
}
