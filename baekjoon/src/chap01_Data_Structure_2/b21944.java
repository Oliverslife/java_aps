package chap01_Data_Structure_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class b21944 {

    static class Data implements Comparable<Data> {
        int P, L, G;
        public Data(int P, int L, int G) {
            this.P = P;
            this.L = L;
            this.G = G;
        }
        @Override
        public int compareTo(Data o) {
            if(this.L == o.L)
                return this.P - o.P;
            return this.L - o.L;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N, M, P, L, G, x;
        Data tmp;
        String order;

        TreeSet<Data> treeSet = new TreeSet<>();        //통합
        List<TreeSet<Data>> list = new ArrayList<>();   //분류 구분용
        Map<Integer, int[]> map = new HashMap<>();      //삭제용 (정확한 정보 필요)

        for(int i=0; i<101; i++)
            list.add(new TreeSet<>());

        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            treeSet.add(new Data(P, L, G));
            list.get(G).add(new Data(P, L, G));
            map.put(P, new int[] {L, G});
        }

        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            switch(order) {
                case "recommend":
                    G = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    sb.append(x == 1 ? list.get(G).last().P : list.get(G).first().P).append("\n");
                    break;
                case "recommend2":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(x == 1 ? treeSet.last().P : treeSet.first().P).append("\n");
                    break;
                case "recommend3":
                    x = Integer.parseInt(st.nextToken());
                    L = Integer.parseInt(st.nextToken());
                    tmp = x == 1 ? treeSet.ceiling(new Data(0, L, 0)) : treeSet.lower(new Data(0, L, 0));
                    sb.append(tmp == null ? -1 : tmp.P).append("\n");
                    break;
                case "add":
                    P = Integer.parseInt(st.nextToken());
                    L = Integer.parseInt(st.nextToken());
                    G = Integer.parseInt(st.nextToken());

                    treeSet.add(new Data(P, L, G));
                    list.get(G).add(new Data(P, L, G));
                    map.put(P, new int[] {L, G});
                    break;
                case "solved":
                    P = Integer.parseInt(st.nextToken());
                    L = map.get(P)[0];
                    G = map.get(P)[1];
                    treeSet.remove(new Data(P, L, G));
                    list.get(G).remove(new Data(P, L, G));
                    map.remove(P);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
//import java.io.BufferedReader;
//        import java.io.BufferedWriter;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.io.OutputStreamWriter;
//        import java.util.*;

//public class Main {
//
//    static class Data implements Comparable<Data> {
//        int P, L, G;
//        public Data(int P, int L, int G) {
//            this.P = P;
//            this.L = L;
//            this.G = G;
//        }
//        @Override
//        public int compareTo(Data o) {
//            if(this.L == o.L)
//                return this.P - o.P;
//            return this.L - o.L;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        int N, M, P, L, G, x;
//        Data tmp;
//        String order;
//
//        TreeSet<Data> treeSet = new TreeSet<>();        //통합
//        List<TreeSet<Data>> list = new ArrayList<>();   //분류 구분용
//        Map<Integer, int[]> map = new HashMap<>();      //삭제용 (정확한 정보 필요)
//
//        for(int i=0; i<101; i++)
//            list.add(new TreeSet<>());
//
//        N = Integer.parseInt(br.readLine());
//
//        while(N-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            P = Integer.parseInt(st.nextToken());
//            L = Integer.parseInt(st.nextToken());
//            G = Integer.parseInt(st.nextToken());
//            treeSet.add(new Data(P, L, G));
//            list.get(G).add(new Data(P, L, G));
//            map.put(P, new int[] {L, G});
//        }
//
//        M = Integer.parseInt(br.readLine());
//        while(M-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            order = st.nextToken();
//            switch(order) {
//                case "recommend":
//                    G = Integer.parseInt(st.nextToken());
//                    x = Integer.parseInt(st.nextToken());
//                    sb.append(x == 1 ? list.get(G).last().P : list.get(G).first().P).append("\n");
//                    break;
//                case "recommend2":
//                    x = Integer.parseInt(st.nextToken());
//                    sb.append(x == 1 ? treeSet.last().P : treeSet.first().P).append("\n");
//                    break;
//                case "recommend3":
//                    x = Integer.parseInt(st.nextToken());
//                    L = Integer.parseInt(st.nextToken());
//                    tmp = x == 1 ? treeSet.ceiling(new Data(0, L, 0)) : treeSet.lower(new Data(0, L, 0));
//                    sb.append(tmp == null ? -1 : tmp.P).append("\n");
//                    break;
//                case "add":
//                    P = Integer.parseInt(st.nextToken());
//                    L = Integer.parseInt(st.nextToken());
//                    G = Integer.parseInt(st.nextToken());
//
//                    treeSet.add(new Data(P, L, G));
//                    list.get(G).add(new Data(P, L, G));
//                    map.put(P, new int[] {L, G});
//                    break;
//                case "solved":
//                    P = Integer.parseInt(st.nextToken());
//                    L = map.get(P)[0];
//                    G = map.get(P)[1];
//                    treeSet.remove(new Data(P, L, G));
//                    list.get(G).remove(new Data(P, L, G));
//                    map.remove(P);
//            }
//        }
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//        br.close();
//
//    }
//
//}