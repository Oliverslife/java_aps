package Chap11_정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for(int x : list) {
            bw.write(x + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
