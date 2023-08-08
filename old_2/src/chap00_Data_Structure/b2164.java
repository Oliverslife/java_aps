package chap00_Data_Structure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class b2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        Deque<Integer> d = new LinkedList<>();
        for(int i=0; i<N; i++)
            d.offer(i+1);

        while(d.size() != 1) {
            d.poll();
            d.offer(d.poll());
        }

        System.out.print(d.poll());
    }
}
