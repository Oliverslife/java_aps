package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class q22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());   //일하면 쌓이는 피로도
        int b = Integer.parseInt(st.nextToken());   //일하면 처리하는 일
        int c = Integer.parseInt(st.nextToken());   //쉬면 줄어드는 피로도
        int m = Integer.parseInt(st.nextToken());   //한계 피로도

        int hours = 24;
        int pirodo = 0;
        int work = 0;

        while(hours-- > 0) {
            if(pirodo + a > m)
                pirodo -= pirodo - c < 0 ? pirodo : c;
            else {
                pirodo += a;
                work += b;
            }
        }

        bw.write(work + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
