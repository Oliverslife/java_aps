package Chap12_집합과맵;

import java.io.*;
import java.util.*;

public class q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        String tmp;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            set.add(br.readLine());
        }
        for(int i=0; i<m; i++) {
            tmp = br.readLine();
            if(set.contains(tmp))       //set의 contains는 map기반 구현으로 O(1)이며, list의 contains는 indexof기반 구현으로 O(n)이다.
                list.add(tmp);
        }
        Collections.sort(list);

        bw.write(list.size() + "\n");
        for(String str : list)
            bw.write(str + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
