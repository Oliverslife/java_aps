package Selected_01_Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
        StringTokenizer plus;
        int plussum = 0;
        int ans = 0;
        int start_checker = 1;

        while(minus.hasMoreTokens()) {
            plus = new StringTokenizer(minus.nextToken(), "+");
            plussum = 0;
            while(plus.hasMoreTokens()) {
                plussum += Integer.parseInt(plus.nextToken());
            }
            if(start_checker == 1) {
                start_checker = 0;
                ans = plussum;
            }
            else
                ans -= plussum;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
