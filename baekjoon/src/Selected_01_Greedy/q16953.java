package Selected_01_Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class q16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ans = 0;

        while(A != B) {
            if(A > B) {
                ans = -1;
                break;
            }
            else if(B % 10 == 1) {
                B /= 10;
                ans++;
            }
            else if(B % 2 == 0) {
                B /= 2;
                ans++;
            }
            else {
                ans = -1;
                break;
            }
        }
        if(ans != -1)
            ans++;

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
