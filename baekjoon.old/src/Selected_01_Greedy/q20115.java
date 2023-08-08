package Selected_01_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Double> list = new ArrayList<>();
        double ans;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Double.parseDouble(st.nextToken()));
        }
        Collections.sort(list);

        ans = list.get(n-1);
        list.remove(n-1);

        for(double d : list) {
            ans += d / 2;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
