package Selected_01_Greedy;

import java.io.*;

public class q1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        String a = "AAAA";
        String b = "BB";

        target = target.replaceAll("XXXX", a);
        target = target.replaceAll("XX", b);
        if(target.contains("X"))
            target = "-1";

        bw.write(target);
        bw.flush();
        bw.close();
        br.close();
    }
}
