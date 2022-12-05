package Chap04_1차원배열;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class q2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int[] arr = new int[9];

        for(int i=0; i<9; i++) {
            list.add(Integer.parseInt(br.readLine()));
            max = Math.max(max, list.get(i));
        }

        bw.write(String.format("%d\n%d", max, list.indexOf(max)+1));
        bw.flush();
        bw.close();
        br.close();
    }
}