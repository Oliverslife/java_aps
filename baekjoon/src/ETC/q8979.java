package ETC;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q8979 {

    static class info implements Comparable<info> {
        int idx, g, s, b;
        public info(int idx, int g, int s, int b) {
            this.idx = idx;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(info o) {
            if(this.g == o.g) {
                if(this.s == o.s)
                    return o.b - this.b;
                return o.s - this.s;
            }
            return o.g - this.g;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<info> list = new ArrayList<>();
        int ans = 1, cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        if(list.get(0).idx == target)
            bw.write(ans + "");
        else {
            for(int i=1; i<n; i++) {
                if(list.get(i - 1).g == list.get(i).g && list.get(i - 1).s == list.get(i).s && list.get(i - 1).b == list.get(i).b)
                    cnt++;
                else {
                    ans += cnt + 1;
                    cnt = 0;
                }
                if(list.get(i).idx == target) {
                    bw.write(ans + "");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
