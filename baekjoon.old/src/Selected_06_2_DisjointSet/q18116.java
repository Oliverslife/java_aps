package Selected_06_2_DisjointSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q18116 {   //10의 6승은 0이 6개란다 멍청아
    static int[] p;
    static int[] cnt;

    static void make() {
        p = new int[1000001];
        cnt = new int[1000001];
        for(int i=0; i<1000001; i++) {
            p[i] = i;
            cnt[i] = 1;
        }
    }

    static int find(int a) {
        if(p[a] == a)
            return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if(ar == br)    return false;
        cnt[ar] += cnt[br];
        p[br] = ar;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        make();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                case "I":
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    union(a, b);
                    break;
                case "Q":
                    int target = Integer.parseInt(st.nextToken());
                    sb.append(cnt[find(target)] + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
