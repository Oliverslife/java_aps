package ETC;

import java.io.*;

public class q8320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()), ans = 0;
        for(int i=1; i<=n; i++)             //가로
            for(int j=i; i*j <= n; j++)     //세로
                ans++;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
