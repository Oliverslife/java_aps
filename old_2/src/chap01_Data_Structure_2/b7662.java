package chap01_Data_Structure_2;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class b7662 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {

            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            while(k-- > 0) {

                st = new StringTokenizer(br.readLine());
                String order_1 = st.nextToken();
                int order_2 = Integer.parseInt(st.nextToken());

                switch (order_1) {
                    case "I":
                        treeMap.put(order_2, treeMap.getOrDefault(order_2, 0) + 1);
                        break;
                    case "D":
                        if(treeMap.isEmpty()) break;
                        int key = order_2 == 1 ? treeMap.lastKey() : treeMap.firstKey();
                        if(treeMap.get(key) == 1)
                            treeMap.remove(key);
                        else
                            treeMap.put(key, treeMap.get(key) - 1);
                }

            }

            sb.append(treeMap.isEmpty() ? "EMPTY\n" : treeMap.lastKey() + " " + treeMap.firstKey() + "\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



    }
}
