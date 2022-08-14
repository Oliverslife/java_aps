package Chap11_정렬;

import java.io.*;
import java.util.*;

public class q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        int tmp = 0;
        int rank;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        sorted.addAll(list);
        Collections.sort(sorted);

        for(int x : sorted) {
            if(!map.containsKey(x))
                map.put(x, tmp++);
        }
        for(int key : list) {
            bw.write(map.get(key) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
