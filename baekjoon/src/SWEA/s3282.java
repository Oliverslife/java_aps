package SWEA;

import java.util.Scanner;

public class s3282 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int[][] data;
        int[][] bag;
        int n, k;

        int t = sc.nextInt();
        for(int tc=1; tc<=t; tc++) {

            n = sc.nextInt();	//물건의 개수
            k = sc.nextInt();	//가방의 부피
            bag = new int[n+1][k+1];
            data = new int[n+1][2];

            for(int i=1; i<=n; i++) {
                data[i][0] = sc.nextInt();	//물건의 부피
                data[i][1] = sc.nextInt();	//물건의 가치
            }

            for(int i=1; i<=n; i++)			//모든 물건을 하나씩 넣어 봄
                for(int j=0; j<=k; j++) {	//모든 무게마다 최적해 갱신
                    if(data[i][0] > j)		//대상 물건을 담을 수 있는 용량이 된다면
                        bag[i][j] = bag[i-1][j];
                    else
                        bag[i][j] = Math.max(bag[i-1][j], bag[i-1][j - data[i][0]] + data[i][1]);

                }
            sb.append("#" + tc + " " + bag[n][k] + "\n");

        }
        sc.close();
        System.out.println(sb);


    }

}