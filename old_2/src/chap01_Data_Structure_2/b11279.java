package chap01_Data_Structure_2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(N-- > 0) {
            int target = sc.nextInt();
            if(target == 0)
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            else
                pq.offer(target);
        }

        sc.close();
        System.out.print(sb);

    }

}