package ETC;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine()), tmp;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        tmp = Integer.parseInt(br.readLine());
        tmp = !map.containsKey(tmp) ? 0 : map.get(tmp);
        bw.write(tmp + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
