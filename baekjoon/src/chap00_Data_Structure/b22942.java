package chap00_Data_Structure;

import java.util.PriorityQueue;
import java.util.Scanner;

public class b22942 {
    // 이전에 풀었던 방식 : 반원을 괄호로 보는 풀이
    // 현재 시도하는 풀이 : 정렬 후 교점 확인 -> 비효율
    static class Circle implements Comparable<Circle> {
        int left, right;
        public Circle(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Circle o) {

            if (this.left == o.left)
                return this.right - o.right;
            return this.left - o.left;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Circle> pq = new PriorityQueue<>();
        while(N-- > 0) {
            int x = sc.nextInt();
            int r = sc.nextInt();
            pq.offer(new Circle(x - r, x + r));
        }
        sc.close();

        String ans = "YES";
        Circle prev = new Circle(Integer.MIN_VALUE, Integer.MIN_VALUE);
        while(!pq.isEmpty()) {
            Circle target = pq.poll();
            if(prev.right >= target.left && prev.right <= target.right) {
                ans = "NO";
                break;
            }
            prev = target;
        }

        System.out.print(ans);

    }
}
