package Selected_02_DataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class q21942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Long> data = new HashMap<>();
        TreeMap<String, Long> ans = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        String parts, name, tname;
        long time, diff;
        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i=2; i<month.length; i++)
            month[i] += month[i-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String tmp = st.nextToken();
        int L = (Integer.parseInt(tmp.substring(0, 3)) * 1440) + (Integer.parseInt(tmp.substring(4, 6)) * 60) + Integer.parseInt(tmp.substring(7));
        int F = Integer.parseInt(st.nextToken());

        while(N-- > 0) {
            time = 0;
            st = new StringTokenizer(br.readLine());
            parts = st.nextToken();
            time += (month[Integer.parseInt(parts.substring(5, 7)) - 1] + Integer.parseInt(parts.substring(8))) * 1440;
            parts = st.nextToken();
            time += (Integer.parseInt(parts.substring(0, 2)) * 60) + Integer.parseInt(parts.substring(3));

            parts = st.nextToken();
            name = st.nextToken() + "X" + parts;
            if(data.isEmpty() || !data.containsKey(name))
                data.put(name, time);
            else {
                diff = time - data.get(name);
                if(diff > L) {
                    st = new StringTokenizer(name, "X");
                    tname = st.nextToken();
                    parts = st.nextToken();//기능하지 않음
                    ans.put(tname, ans.getOrDefault(tname, 0L) + (diff - L) * F);
                }
                data.remove(name);
            }
        }

        if(ans.isEmpty())
            sb.append("-1");
        else
            for(Map.Entry<String, Long> e : ans.entrySet())
                sb.append(e.getKey() + " " + e.getValue() + "\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}