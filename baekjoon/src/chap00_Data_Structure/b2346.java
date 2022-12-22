package chap00_Data_Structure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class b2346 {

    static class Balloon {
        int index, order;

        public Balloon(int index, int order) {
            this.index = index;
            this.order = order;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        Deque<Balloon> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++)
            deque.offer(new Balloon(i, sc.nextInt()));
        sc.close();

        while(deque.size() != 1) {
            Balloon picked = deque.poll();
            sb.append(picked.index + " ");
            if(picked.order > 0)
                for(int i=0; i<picked.order - 1; i++)
                    deque.offer(deque.poll());
            else
                for(int i=0; i>picked.order; i--)
                    deque.offerFirst(deque.pollLast());
        }
        sb.append(deque.poll().index);

        System.out.print(sb);
    }
}
