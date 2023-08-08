package Chap08_기본수학2;

import java.io.*;

public class q2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;    //소수 합
        int min = 0;    //소수 최솟값
        int cnt = 0;    //소수 개수

        boolean[] sosu = new boolean[n+1];
        sosu[0] = sosu[1] = true;

        //소수찾기, false로 남는 것들이 소수
        for(int i=2; i*i<= n; i++) {
            if(sosu[i])
                continue;
            for(int j=i*2; j<n+1; j+=i)
                sosu[j] = true;
        }

        //정답 찾기
       for(int i=m; i<=n; i++) {
            if(!sosu[i]) {              //소수라면
                cnt++;                  //개수 추가
                sum += i;               //더해주기
                if(cnt == 1)
                    min = i;            //최솟값 설정
            }
        }

       //정답 출력
       if(cnt == 0)
           bw.write("-1");
       else
           bw.write(String.format("%d\n%d", sum, min));

        bw.flush();
        bw.close();
        br.close();
    }
}
