package Chap12_집합과맵;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class q1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int anum = Integer.parseInt(st.nextToken());
        int bnum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        for(int x : a) {
            if(!b.contains(x))
                ans++;
        }
        for(int x : b) {
            if(!a.contains(x))
                ans++;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
