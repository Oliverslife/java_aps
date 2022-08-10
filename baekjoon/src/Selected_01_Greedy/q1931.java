package Selected_01_Greedy;

import java.io.*;
import java.util.*;

public class q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        Map.Entry<Integer, Integer> tmp;

        int start;
        int end;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            tmp = new AbstractMap.SimpleEntry<>(start, end);
            list.add(tmp);
        }
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() == o2.getValue())
                    return o1.getKey() - o2.getKey();
                return o1.getValue() - o2.getValue();
            }
        });

        int last = 0;
        int ans = 0;
        for(Map.Entry<Integer, Integer> e : list) {
            if(e.getKey() >= last) {
                last = e.getValue();
                ans++;
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
