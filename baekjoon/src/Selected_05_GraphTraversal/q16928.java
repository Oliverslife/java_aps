package Selected_05_GraphTraversal;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class q16928 {
    public static void main(String[] args) {
        int[] warp = new int[101];
        int[] record = new int[101];

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt() + sc.nextInt();
        while(data-- > 0)
            warp[sc.nextInt()] = sc.nextInt();
        sc.close();

        record[1] = 0;
        int cnt = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        search:
        while(!q.isEmpty()) {
            int tmp = q.poll();
            for(int i=1; i<=6; i++) {
                if(tmp + i > 100) break search;
                if(record[tmp + i] != 0) continue;
                if(warp[tmp + i] == 0) {
                    q.offer(tmp + i);
                    record[tmp + i] = record[tmp] + 1;
                }
                else {
                    if(record[warp[tmp + i]] != 0) continue;
                    q.offer(warp[tmp + i]);
                    record[warp[tmp + i]] = record[tmp] + 1;
                }
            }
        }
        System.out.print(record[100]);
    }
}
