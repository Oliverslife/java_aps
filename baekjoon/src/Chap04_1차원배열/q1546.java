package Chap04_1차원배열;

import java.io.*;
import java.util.*;

public class q1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double sum = 0;
        double[] arr = new double[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<arr.length; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(arr);

        for(double i : arr) {
            sum += (i / arr[arr.length - 1]) * 100;
        }

        bw.write(String.valueOf(sum / arr.length));
        bw.flush();;
        bw.close();
        br.close();
    }
}
