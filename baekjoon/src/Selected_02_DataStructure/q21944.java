package Selected_02_DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q21944 {

    static class Q implements Comparable<Q> {
        int P, L, G;

        public Q(int P, int L, int G) {
            this.P = P;
            this.L = L;
            this.G = G;
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
        List<TreeSet<Q>> list = new ArrayList<>();
        TreeSet<Q> set = new TreeSet<>();
        Map<Integer, int[]> map = new HashMap<>();

        int N, P, L, M, G, order1, order2, order3, tmp;
        String order;

        for(int i=0; i<=100; i++)
            list.add(new TreeSet<>());

        N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            list.get(G).add(new Q(P, L, G));
            set.add(new Q(P, L, G));
            map.put(P, new int[] {L, G});
        }
        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            switch (order) {
                case "recommend":
                    order1 = Integer.parseInt(st.nextToken());
                    order2 = Integer.parseInt(st.nextToken());
                    tmp = order2 == 1 ? list.get(order1).last().P : list.get(order1).first().P;
                    sb.append(tmp + "\n");
                    break;
                case "recommend2":
                    order1 = Integer.parseInt(st.nextToken());
                    tmp = order1 == 1 ? set.last().P : set.first().P;
                    sb.append(tmp + "\n");
                    break;
                case "recommend3":
                    order1 = Integer.parseInt(st.nextToken());
                    order2 = Integer.parseInt(st.nextToken());
                    tmp = order1 == 1 ? set.ceiling(new Q(0, order2, 0)) == null ? -1 : set.ceiling(new Q(0, order2, 0)).P : set.lower(new Q(0, order2, 0)) == null ? -1 : set.lower(new Q(0, order2, 0)).P;
//                    if (order1 == 1) {
//                        if (set.ceiling(new Q(0, order2, 0)) == null)
//                            sb.append("-1\n");
//                        else
//                            sb.append(set.ceiling(new Q(0, order2, 0)).P + "\n");
//                    } else {
//                        if (set.lower(new Q(0, order2, 0)) == null)
//                            sb.append("-1\n");
//                        else
//                            sb.append(set.lower(new Q(0, order2, 0)).P + "\n");
//                    }
                    sb.append(tmp + "\n");
                    break;
                case "add":
                    order1 = Integer.parseInt(st.nextToken());
                    order2 = Integer.parseInt(st.nextToken());
                    order3 = Integer.parseInt(st.nextToken());
                    set.add(new Q(order1, order2, order3));
                    list.get(order3).add(new Q(order1, order2, order3));
                    map.put(order1, new int[]{order2, order3});
                    break;
                case "solved":
                    order1 = Integer.parseInt(st.nextToken());
                    set.remove(new Q(order1, map.get(order1)[0], map.get(order1)[1]));
                    list.get(map.get(order1)[1]).remove(new Q(order1, map.get(order1)[0], map.get(order1)[1]));
                    map.remove(order1);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}