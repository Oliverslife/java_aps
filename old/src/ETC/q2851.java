package ETC;

import java.io.*;

public class q2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = 0, target1 = 0, target2 = 0, tmp;

        for(int i=0; i<10; i++) {
            tmp = Integer.parseInt(br.readLine());
            ans += tmp;
            if(ans >= 100) {
                target2 = ans;
                break;
            }
            target1 = ans;
        }
        ans = Math.abs(100 - target1) >= Math.abs(100 - target2) ? target2 : target1;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
