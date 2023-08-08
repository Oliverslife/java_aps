package chap00_Data_Structure;

import java.util.*;

public class b1966 {

    static class Paper {
        int index, priority;

        public Paper(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int tc = sc.nextInt();
        while(tc-- > 0) {

            int N = sc.nextInt();
            int M = sc.nextInt();

            Queue<Paper> order = new LinkedList<>();
            Queue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

            for(int i=0; i<N; i++) {
                int tmp = sc.nextInt();
                order.offer(new Paper(i, tmp));
                priority.offer(tmp);
            }

            int ans = 1;
            while(!(order.peek().priority == priority.peek() && order.peek().index == M)) {

                if(order.peek().priority != priority.peek())
                    order.offer(order.poll());
                else {
                    order.poll();
                    priority.poll();
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
