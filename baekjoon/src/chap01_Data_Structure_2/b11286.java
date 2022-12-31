package chap01_Data_Structure_2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b11286 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o2) == Math.abs(o1))
                    return o1 - o2;
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        while(N-- > 0) {
            int x = sc.nextInt();
            if(x != 0)
                pq.offer(x);
            else
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
        }

        System.out.print(sb);

    }
}
