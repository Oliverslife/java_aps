package Chap11_정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q11650 {
    static class target implements Comparable<target> {
        int x, y;

        public target(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }

        @Override
        public int compareTo(target o) {
            if(this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<target> list = new ArrayList<>();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new target(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        for(target t : list)
            bw.write(t + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}
