package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q4101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0)
                break;
            String ans = a > b ? "Yes\n" : "No\n";
            bw.write(ans + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
