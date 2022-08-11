package Selected_01_Greedy;

import java.io.*;

public class q20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String target = br.readLine();
        char tmp = '\0';
        int bcnt = 0;
        int rcnt = 0;
        int ans = 0;

        for(char ch : target.toCharArray()) {
            if(tmp != ch && ch == 'B')
                bcnt++;
            else if(tmp != ch && ch == 'R')
                rcnt++;
            tmp = ch;
        }

        ans = Math.min(bcnt, rcnt) + 1;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
