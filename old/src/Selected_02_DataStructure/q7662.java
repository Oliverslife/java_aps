package Selected_02_DataStructure;

import java.io.*;
import java.util.*;

public class q7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<Integer, Integer> tmap;
        StringTokenizer st;
        String ans;
        int target;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            tmap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            while(k-- > 0) {
                st = new StringTokenizer(br.readLine());
                char order = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                switch (order) {
                    case 'I':
                        tmap.put(n, tmap.getOrDefault(n, 0) + 1);
                        break;
                    case 'D':
                        if(tmap.size() == 0)
                            continue;
                        target = (n == 1) ? tmap.lastKey() : tmap.firstKey();
                        if(tmap.get(target) == 1)
                            tmap.remove(target);
                        else
                            tmap.put(target, tmap.get(target) - 1);
                }
            }
            ans = tmap.isEmpty() ? "EMPTY\n" : tmap.lastKey() + " " + tmap.firstKey() + "\n";
            bw.write(ans);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
