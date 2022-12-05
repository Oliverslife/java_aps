package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int room = 0;

        int n = Integer.parseInt(st.nextToken());
        double k = Double.parseDouble(st.nextToken());
        int[][] person = new int[2][6];
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            person[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken()) - 1]++;
        }

        for(int i=0; i<2; i++)
            for(int j=0; j<6; j++)
                room += Math.ceil(person[i][j] / k);

        bw.write(room + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
