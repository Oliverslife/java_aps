package SSAFY_IM준비;

import java.io.*;
import java.util.*;

public class q20440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> tset = new TreeSet<>();
        List<Integer> list;

        int a, b, c;
        int N = Integer.parseInt(br.readLine());
        int[] start = new int[N], end = new int[N], mosqsum;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            start[i] = a;
            end[i] = b;
            tset.add(a);
            tset.add(b);
        }

        list = new ArrayList<>(tset);
        mosqsum = new int[list.size()];

        for(int i=0; i<N; i++) {
            a = Collections.binarySearch(list, start[i]);
            b = Collections.binarySearch(list, end[i]);
            for(int j=a; j<b; j++)
                mosqsum[j]++;
        }

        a = 0;
        b = -1;
        c = -1;
        for(int i=0; i<list.size(); i++) {
            if(mosqsum[i] > a) {
                b = i;
                c = i;
                a = mosqsum[i];
            }
            c = (mosqsum[i] == a && i - 1 == c) ? i : c;
        }
        sb.append(a + "\n" + list.get(b) + " " + list.get(c + 1));
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
