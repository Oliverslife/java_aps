package chap01_Data_Structure_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b21944 {

    static class Data implements Comparable<Data> {
        int P, L;
        public Data(int P, int L) {
            this.P = P;
            this.L = L;
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

        TreeSet<Data> treeSet = new TreeSet<>();            //통합
        List<TreeSet<Data>> list = new ArrayList<>();       //분류 구분용
        List<TreeSet<Integer>> dlist = new ArrayList<>();  //삭제용
        for(int i=0; i<101; i++) {
            list.add(new TreeSet<>());
            dlist.add(new TreeSet<>());
        }

        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            treeSet.add(new Data(P, L));
            list.get(G).add(new Data(P, L));
            dlist.get(G).add(P);
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
                    tmp = x == 1 ? treeSet.floor(new Data(0, L)) : treeSet.lower(new Data(100001, L));  //이 부분이 문제 : treeSet.lower에서 의도한 값이 안나옴 - 수정요망
                    sb.append(tmp == null ? -1 : tmp.P).append("\n");
                    break;
                case "add":
                    P = Integer.parseInt(st.nextToken());
                    L = Integer.parseInt(st.nextToken());
                    G = Integer.parseInt(st.nextToken());

                    for(int i=1; i<101; i++) {
                        if(!dlist.get(i).contains(P)) continue;
                        tmp = list.get(i).ceiling(new Data(P, 0));
                        dlist.get(i).remove(P);
                        list.get(i).remove(tmp);
                        treeSet.remove(tmp);
                        System.out.println("제거하게되는 경우의 P, L, G : " + tmp.P + " " + tmp.L + " " + i);
                        break;
                    }

                    treeSet.add(new Data(P, L));
                    list.get(G).add(new Data(P, L));
                    dlist.get(G).add(P);
                    break;
                case "solved":
                    P = Integer.parseInt(st.nextToken());
                    for(int i=1; i<101; i++) {
                        if(!dlist.get(i).contains(P)) continue;
                        tmp = list.get(i).ceiling(new Data(P, 0));
                        if(tmp != null) {
                            list.get(i).remove(tmp);
                            treeSet.remove(tmp);
                            dlist.get(i).remove(P);
                            System.out.println("제거하게되는 경우의 P, L, G : " + tmp.P + " " + tmp.L + " " + i);
                            break;
                        }
                    }
                    break;
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}