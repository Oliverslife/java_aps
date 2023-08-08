package Chap11_정렬;

import java.io.*;
import java.util.*;

public class q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int tmp, avg, mid, range, mod;
        double sum = 0;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            tmp = Integer.parseInt(br.readLine());
            sum += tmp;
            list.add(tmp);
        }
        Collections.sort(list);
        avg = (int)Math.round(sum / n);
        mid = list.get(n / 2);
        range = (list.get(n-1) + 4000) - (list.get(0) + 4000);

        for(int x : list) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        tmp = 0;        //재활용
        for(int key : map.values()) {
            tmp = Math.max(tmp, key);
        }
        list.clear();   //재활용
        for(int key : map.keySet()) {
            if(map.get(key) == tmp)
                list.add(key);
        }
        Collections.sort(list);
        if(list.size() > 1)
            mod = list.get(1);
        else
            mod = list.get(0);


        bw.write(avg + "\n" + mid + "\n" + mod + "\n" + range + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
