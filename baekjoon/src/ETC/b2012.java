package ETC;

import java.util.PriorityQueue;
import java.util.Scanner;

public class b2012 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
            pq.offer(sc.nextInt());
        sc.close();

        int tmp = 1;
        long ans = 0;
        while(N-- > 0)
            ans += Math.abs(tmp++ - pq.poll());

        System.out.println(ans);

    }
}
