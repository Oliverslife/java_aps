package Selected_01_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q20300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Long> list = new ArrayList<>();
        long ans = 0;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            list.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(list);

        if(n % 2 == 0) {
            for(int i=0; i<n/2; i++) {
                ans = Math.max(ans, list.get(i) + list.get(n-1-i));
            }
        }
        else {
            ans = list.get(n-1);
            for(int i=0; i<(n-1)/2; i++) {
                ans = Math.max(ans, list.get(i) + list.get(n-2-i));
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
