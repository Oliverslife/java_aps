package chap00_Data_Structure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class b10866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> d = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        while(N-- > 0) {
            switch(sc.next()) {
                case "push_front":
                    d.offerFirst(sc.nextInt());
                    break;
                case "push_back":
                    d.offer(sc.nextInt());
                    break;
                case "pop_front":
                    sb.append(d.isEmpty() ? -1 : d.poll()).append("\n");
                    break;
                case "pop_back":
                    sb.append(d.isEmpty() ? -1 : d.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(d.size()).append("\n");
                    break;
                case "empty":
                    sb.append(d.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(d.isEmpty() ? -1 : d.peek()).append("\n");
                    break;
                case "back":
                    sb.append(d.isEmpty() ? -1 : d.peekLast()).append("\n");
            }
        }
        sc.close();
        System.out.print(sb);
    }
}
