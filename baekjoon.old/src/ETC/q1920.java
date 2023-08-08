package ETC;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class q1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n, m, tmp;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            set.add(Integer.parseInt(st.nextToken()));

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            tmp = Integer.parseInt(st.nextToken());
            if(set.contains(tmp))
                sb.append("1\n");
            else
                sb.append("0\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.flush();
        br.close();
    }
}
