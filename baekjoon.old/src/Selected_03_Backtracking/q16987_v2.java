package Selected_03_Backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q16987_v2 {
    static int n, ans = 0;
    static List<Egg> eggs = new ArrayList<>();
    static class Egg {
        int hp, dmg;
        public Egg(int hp, int dmg) {
            this.hp = hp;
            this.dmg = dmg;
        }
    }
    static void eggBreak(int now) {
        if(now == n) {
            int cnt = 0;
            for(int i=0; i<n; i++)
                if(eggs.get(i).hp <= 0)
                    cnt++;
            ans = Math.max(ans, cnt);
            return;
        }

        boolean noTarget = true;
        for(int i=0; i<n; i++) {
            if(i == now || eggs.get(i).hp <= 0 || eggs.get(now).hp <= 0)
                continue;
            noTarget = false;
            eggs.get(now).hp -= eggs.get(i).dmg;
            eggs.get(i).hp -= eggs.get(now).dmg;
            eggBreak(now + 1);
            eggs.get(now).hp += eggs.get(i).dmg;
            eggs.get(i).hp += eggs.get(now).dmg;
        }
        if(noTarget)
            eggBreak(now + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs.add(new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        eggBreak(0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}