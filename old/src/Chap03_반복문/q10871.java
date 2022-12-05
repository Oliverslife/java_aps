package Chap03_반복문;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int target;

        while (st.hasMoreTokens()) {
            target = Integer.parseInt(st.nextToken());
            if (target < x)
                bw.write(String.valueOf(target) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
