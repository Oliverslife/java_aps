package ETC;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class q1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());
        bw.write(n.divide(m) + "\n" + n.mod(m));
        bw.flush();
        bw.close();
        br.close();
    }
}
