package Selected_01_Greedy;

import java.util.Scanner;

public class q11509 {
    /*
     * 화살 적중 시 높이가 1 감소
     * 입력받은 시점 이전에 높이가 1 높은 풍선이 존재한다면 입력받은 풍선은 추가화살 없이 터뜨릴 수 있음
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int target, arrow = 0;
        int[] data = new int[1000002];

        while(N-- > 0) {
            target = sc.nextInt();
            if(data[target + 1] > 0) {
                data[target]++;
                data[target + 1]--;
            }
            else {
                data[target]++;
                arrow++;
            }
        }
        sc.close();
        System.out.println(arrow);

    }

}
