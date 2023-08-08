package Chap09_재귀;

import java.io.*;

public class q11729 {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    static void h(int num, int col1, int col2, int col3) throws IOException {   //바닥부터 생각하기, 원반수-시작지점-보조기둥-목표지점 순
        cnt++;
        if(num == 1) {                               //col1에서 col3으로 옮긴다고 할 때,
            sb.append(col1 + " " + col3 + "\n");     //원판 한개면 그냥 옮기기만 하면 됨
            return;
        }
        h(num - 1, col1, col3, col2);           //num-1개의 원판을 1에서 2로 이동
        sb.append(col1 + " " + col3 + "\n");         //원판 하나(맨 아래)를 1에서 3으로 이동
        h(num - 1, col2, col1, col3);           //나머지 2에 쌓인 잔여원판(num-1개)들을 마저 3으로 이동
   }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        h(num, 1, 2, 3);

        bw.write(String.format("%d", cnt) + "\n");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
