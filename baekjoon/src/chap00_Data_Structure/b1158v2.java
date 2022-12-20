package chap00_Data_Structure;

import java.util.ArrayList;
import java.util.Scanner;

public class b1158v2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++)
            list.add(i + 1);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        while(!list.isEmpty()) {
            index = (index + K - 1) % N;
            sb.append(list.get(index));
            if(N != 1)
                sb.append(", ");
            list.remove(index);
            N--;
        }

        sb.append(">");
        System.out.print(sb);

    }
}
