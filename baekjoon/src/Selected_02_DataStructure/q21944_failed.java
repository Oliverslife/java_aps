package Selected_02_DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q21944_failed {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<TreeMap<Integer, Integer>> list = new ArrayList<>();

        for(int i=0; i<=100; i++)
            list.add(new TreeMap<>());

        int N, P, L, M, G, order1, order2, order3, tmp;
        String order;

        N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            list.get(L).put(P, G);
        }
        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            switch(order) {
                case "recommend":
                    order1 = Integer.parseInt(st.nextToken());
                    order2 = Integer.parseInt(st.nextToken());
                    if(order2 == 1)
                        for(int i=100; i>=1; i--) {
                            if(!list.get(i).isEmpty() && list.get(i).containsValue(order1)) {
                                sb.append(list.get(i).lastKey() + "\n");
                                break;
                            }
                        }
                    else
                        for(int i=1; i<=100; i++) {
                            if(!list.get(i).isEmpty()) {
                                if(!list.get(i).isEmpty() && list.get(i).containsValue(order1)) {
                                    sb.append(list.get(i).firstKey() + "\n");
                                    break;
                                }
                            }
                        }
                    break;
                case "recommend2":
                    order1 = Integer.parseInt(st.nextToken());
                    if(order1 == 1) {
                        for(int i=100; i>=1; i--)
                            if(!list.get(i).isEmpty()) {
                                sb.append(list.get(i).lastKey() + "\n");
                                break;
                            }
                    }
                    else {
                        for(int i=1; i<=100; i++)
                            if(!list.get(i).isEmpty()) {
                                sb.append(list.get(i).firstKey() + "\n");
                                break;
                            }
                    }
                    break;
                case "recommend3":
                    tmp = -1;
                    order1 = Integer.parseInt(st.nextToken());
                    order2 = Integer.parseInt(st.nextToken());
                    if(order1 == 1) {
                        for(int i=order2; i<=100; i++)
                            if(!list.get(i).isEmpty()) {
                                tmp = list.get(i).firstKey();
                                break;
                            }
                        sb.append(tmp + "\n");
                    }
                    else {
                        for(int i=order2; i>=1; i--)
                            if(!list.get(i).isEmpty()) {
                                tmp = list.get(i).lastKey();
                                break;
                            }
                        sb.append(tmp + "\n");
                    }
                    break;
                case "add":
                    order1 = Integer.parseInt(st.nextToken());
                    order2 = Integer.parseInt(st.nextToken());
                    order3 = Integer.parseInt(st.nextToken());
                    list.get(order2).put(order1, order3);
                    break;
                case "solved":
                    order1 = Integer.parseInt(st.nextToken());
                    for(int i=0; i<=100; i++)
                        list.get(i).remove(order1);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
