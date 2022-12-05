package Selected_01_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q1181 {
    static class target implements Comparable<target> {
        String str;
        int len;

        public target(String str) {
            this.str = str;
            this.len = str.length();
        }

        @Override
        public String toString() {
            return this.str;
        }

        @Override
        public int compareTo(target o) {
            if(this.len == o.len)
                return this.str.compareTo(o.str);
            return this.len - o.len;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<target> list = new ArrayList<>();
        StringTokenizer st;
        String tmp = "";

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new target(st.nextToken()));
        }
        Collections.sort(list);

        for(target t : list) {
            if(!tmp.equals(t.str))
                bw.write(t + "\n");
            tmp = t.str;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}