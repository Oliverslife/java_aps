package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q18917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine()), order;
        long target, sum = 0L, xor = 0L;
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());
            switch(order) {
                case 1:
                    target = Long.parseLong(st.nextToken());
                    sum += target;
                    xor ^= target;
                    break;
                case 2:
                    target = Long.parseLong(st.nextToken());
                    sum -= target;
                    xor ^= target;
                    break;
                case 3:
                    sb.append(sum + "\n");
                    break;
                case 4:
                    sb.append(xor + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
