//package Selected_03_Backtracking;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class q16987 {
//    static int n, ans = 0;
//    static List<Egg> eggs = new ArrayList<>();
//    static class Egg {
//        int hp, dmg;
//        public Egg(int hp, int dmg) {
//            this.hp = hp;
//            this.dmg = dmg;
//        }
//    }
//    static void eggBreak(int now) {//now는 현재 들고있는 계란
//        if(now == n) {
//            int cnt = 0;
//            for(int i=0; i<n; i++)
//                if(eggs.get(i).hp <= 0)
//                    cnt++;
//            ans = Math.max(ans, cnt);
//            return;
//        }
//
//        boolean noTarget = true;
//        for(int i=0; i<n; i++) {                    //attack할 대상 찾기
//            if(i != now && eggs.get(i).hp > 0) {    //들고있는 계란이 아니면서 깨지지 않은 상대를 attack
//                if(eggs.get(now).hp <= 0)           //들어올린 계란의 hp가 0 이하라면
//                    eggBreak(now + 1);         //다음 계란 들기
//                noTarget = false;                   //attack 가능한 계란이 존재한다면
//                eggs.get(now).hp -= eggs.get(i).dmg;//대상에게 attack
//                eggs.get(i).hp -= eggs.get(now).dmg;//들고있는 계란에 dmg 계산
//                eggBreak(now + 1);             //attack 후 다음 대상으로 넘어가기
//                eggs.get(now).hp += eggs.get(i).dmg;//대상(i)을 attack하지 않고 다음 대상을 선택했을 경우를 위한 초기화
//                eggs.get(i).hp += eggs.get(now).dmg;
//            }
//        }
//        if(noTarget)                //attack할 대상이 없으면 (다 박살나있으면)
//            eggBreak(now + 1); //탈출조건까지 진행은 해야지...
//
//    }
//
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        n = Integer.parseInt(br.readLine());
//        for(int i=0; i<n; i++) {
//            st = new StringTokenizer(br.readLine());
//            eggs.add(new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
//        }
//        eggBreak(0);
//        bw.write(ans + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}
