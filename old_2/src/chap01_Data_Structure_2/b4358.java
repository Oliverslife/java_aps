package chap01_Data_Structure_2;

import java.io.*;
import java.util.*;

public class b4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new HashMap<>();
        Map<String, Double> ans = new HashMap<>();
        List<String> toSort;
        StringBuilder sb = new StringBuilder();
        String target;
        int n = 0;

        while((target = br.readLine()) != null && !target.isEmpty()) {
            map.put(target, map.getOrDefault(target, 0) + 1);
            n++;
        }
        for(Map.Entry<String, Integer> tmp : map.entrySet()) {
            double calculated = tmp.getValue() * 100 / (double)n;
            ans.put(tmp.getKey(), calculated);
        }
        toSort = new ArrayList<>(map.keySet());
        Collections.sort(toSort);
        for(String str : toSort)
            bw.write(String.format("%s %.4f\n", str, ans.get(str)));

        bw.flush();
        bw.close();
        br.close();
    }
}

