package Selected_04_BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q21315 {
    static int n;
    static int[] origin, card, comp, ans = new int[2];

    static void mix(int k) {

        Stack<Integer> total = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        List<Integer> nc = new ArrayList<>();

        int b = k;
        int start = 0;
        int end = n - (int)Math.pow(2, b);
        int recur = k+1;

        while(recur-- > 0) {

            for(int i=start; i<end; i++)
                tmp.push(card[i]);
            while(!tmp.isEmpty())
                total.push(tmp.pop());
            start = n - (int)Math.pow(2, b--);;
            end = start + (int)Math.pow(2, b);

        }
        total.push(card[n-1]);
        while(!total.isEmpty())
            nc.add(total.pop());
        for(int i=0; i<n; i++)
            card[i] = nc.get(i);
    }

    static boolean check(int a, int b) {

        mix(a);
        mix(b);

        for(int i=0; i<n; i++)
            if(card[i] != comp[i]) {
                for(int j=0; j<n; j++)
                    card[j] = origin[j];
                return false;
            }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        origin = new int[n];
        card = new int[n];
        comp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            comp[i] = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            card[i] = i + 1;
            origin[i] = i + 1;
        }

        all:
        for(int i=1; Math.pow(2, i) <= n; i++)
            for(int j=1; Math.pow(2, j) <= n; j++)
                if(check(i, j)) {
                    sb.append(i + " " + j);
                    break all;
                }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
