package Selected_07_Memoization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] data = new int[2][3];
        int[][] cal = new int[2][3];
        int a, b, c;

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            data[0][0] = cal[0][0] + a;
            data[0][1] = cal[0][1] + b;
            data[0][2] = cal[0][2] + c;

            data[1][0] = cal[1][0] + a;
            data[1][1] = cal[1][1] + b;
            data[1][2] = cal[1][2] + c;


            cal[0][0] = Math.max(data[0][0], data[0][1]);
            cal[0][1] = Math.max(data[0][0], Math.max(data[0][1], data[0][2]));
            cal[0][2] = Math.max(data[0][1], data[0][2]);

            cal[1][0] = Math.min(data[1][0], data[1][1]);
            cal[1][1] = Math.min(data[1][0], Math.min(data[1][1], data[1][2]));
            cal[1][2] = Math.min(data[1][1], data[1][2]);
        }

        sb.append(Math.max(cal[0][0], Math.max(cal[0][1], cal[0][2]))).append(" ");
        sb.append(Math.min(cal[1][0], Math.min(cal[1][1], cal[1][2])));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}