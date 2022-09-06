package Selected_03_Backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q1174 {      // --> 다시 공부하기
    static int n, ans = 0;
    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> list = new ArrayList<>();
    static void makeNum(int idx, long now) {
        if(!list.contains(now))                             //중복을 확인하며 담기
            list.add(now);
        if(idx >= 10)
            return;

        makeNum(idx + 1, now);                           //큰 수가 담긴 배열의 인덱스부터 증가, 선택 안하는 경우
        makeNum(idx + 1, now * 10 + arr[idx]);      //위의 이유로 높은 자리의 수가 더 큰 수가 보장됨, 현재 수에 10을 곱해 자릿수를 옮기고 1의 자리에 작은 값을 추가

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        makeNum(0, 0);
        Collections.sort(list);

//        if(n > 1023)
//            bw.write("-1");
//        else
//            bw.write(list.get(n-1) + "");

        try {                                                   //이런 좋은 방법이
            bw.write(list.get(n-1) + "");
        }catch (Exception e) {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
