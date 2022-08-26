package Selected_02_DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q21939 {

    static class Q implements Comparable<Q> {
        int P, L;

        public Q(int P, int L) {
            this.P = P;
            this.L = L;
        }

        @Override
        public int compareTo(Q o) {
            if(this.L == o.L)
                return this.P - o.P;
            return this.L - o.L;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Q> set = new TreeSet<>();

        int N, P, L, M, order1, order2;
        String order;

        N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map.put(P, L);
            set.add(new Q(P, L));
        }
        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            switch(order) {
                case "recommend":
                    order1 = Integer.parseInt(st.nextToken());
                    if(map.isEmpty())
                        break;
                    else if(order1 == 1)
                        sb.append(set.last().P + "\n");
                    else
                        sb.append(set.first().P + "\n");
                    break;
                case "add":
                    order1 = Integer.parseInt(st.nextToken());
                    order2 = Integer.parseInt(st.nextToken());
                    map.put(order1, order2);
                    set.add(new Q(order1, order2));
                    break;
                case "solved":
                    order1 = Integer.parseInt(st.nextToken());
                    set.remove(new Q(order1, map.get(order1)));
                    map.remove(order1);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}