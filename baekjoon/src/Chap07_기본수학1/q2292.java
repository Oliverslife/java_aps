package Chap07_기본수학1;

import java.io.*;

public class q2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(br.readLine());
        int door_num = 1;
        int door = 1;

        while(target > door_num) {
            door_num += 6 * door;
            door += 1;
        }

        bw.write(String.valueOf(door));
        bw.flush();
        bw.close();
        br.close();
    }
}
