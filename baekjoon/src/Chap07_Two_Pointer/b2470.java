package Chap07_Two_Pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2470 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int val = Integer.MAX_VALUE, i = 0, j = arr.length - 1, sum, A = 0, B = 0;


        while (i < j) {
            sum = arr[i] + arr[j];
            if (Math.abs(sum) < val) {
                val = Math.abs(sum);
                A = arr[i];
                B = arr[j];
            }
            if (sum > 0)
                j--;
            else
                i++;
        }

        sb.append(A + " " + B);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}