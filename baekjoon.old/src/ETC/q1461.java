package ETC;

import java.io.*;
import java.util.*;

public class q1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> pluspq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> minuspq = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());   //옮겨야 하는 책의 수
        int m = Integer.parseInt(st.nextToken());   //한 번에 들 수 있는 책의 개수

        // m개의 책만을 옮길 수 있음 > 다시 0의 위치로 와야 함 > 가까운 책부터 처리해야 함 > 그런데 음수와 양수는 방향이 달라서 따로 관리
        // > 마지막은 되돌아올 필요가 없기에 마지막에 들 수 있는 최대 개수를 들고 가야 함 > 내림차순정렬? > 멀리있는 책부터 처리해야되네?

        int tmp;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if(tmp >= 0)
                pluspq.offer(tmp);
            else
                minuspq.offer(tmp);
        }
        //입력 데이터 처리

//        int maxlen = Math.abs(pluspq.peek()) > Math.abs(minuspq.peek()) ? Math.abs(pluspq.peek()) : Math.abs(minuspq.peek()); 널포인터에러
        int maxlen = 0;
        //가장 먼 거리에서 마무리하고 되돌아올 필요가 없기에 한번 빼주어야 함 > 절대값 처리해줘야되네
        int ans = 0;

        while(!pluspq.isEmpty()) {      //빌 때까지 털어볼까
            for(int i=0; i<m; i++) {    //m개씩 들고 옮겨
                if(pluspq.isEmpty())
                    break;           //도중에 털리면 넘어가
                tmp = pluspq.poll();
                maxlen = Math.max(maxlen, tmp);

                if(i == 0)              //m개 중 가장 긴 거리의 값을 구해야 함
                    ans += tmp;
            }
        }

        while(!minuspq.isEmpty()) {
            for(int i=0; i<m; i++) {
                if(minuspq.isEmpty())
                    break;
                tmp = minuspq.poll();
                maxlen = Math.max(maxlen, Math.abs(tmp));

                if(i == 0)
                    ans += Math.abs(tmp);
            }
        }

        ans = ans * 2 - maxlen;         //왕복 2배에서 최장거리 빼줌 (그 자리에서 마무리하기에_
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
