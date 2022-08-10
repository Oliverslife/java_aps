package Selected_01_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();

        int start;
        int end;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            list.add(Map.entry(start, end));
        }
        list.sort(Map.Entry.comparingByValue());

        int tmp = 0;
        int ans = 0;
        for(Map.Entry<Integer, Integer> e : list) {
            if(e.getKey() >= tmp) {
                tmp = e.getValue();
                ans++;
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
