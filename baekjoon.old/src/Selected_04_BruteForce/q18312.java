package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class q18312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;

        for(int i=0; i<=n; i++)
            for(int j=0; j<60; j++)
                for(int l=0; l<60; l++) {
                    String str = String.format("%02d", i) + String.format("%02d", j) + String.format("%02d", l);
                    if(str.contains(String.valueOf(k)))
                        ans++;
                }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
