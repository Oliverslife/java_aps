package chap01_Data_Structure_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class b21939 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<TreeSet<Integer>> book = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<101; i++)
            book.add(new TreeSet<>());

        int N = sc.nextInt();
        while(N-- > 0) {
            int P = sc.nextInt();
            int L = sc.nextInt();
            book.get(L).add(P);
        }

        int M = sc.nextInt();

        int x, P, L;
        while(M-- > 0) {
            String order = sc.next();
            switch(order) {
                case "recommend":
                    x = sc.nextInt();
                    if(x == 1)
                        for(int i=100; i>0; i--) {
                            if(book.get(i).isEmpty()) continue;
                            sb.append(book.get(i).last()).append("\n");
                            break;
                        }
                    else
                        for(int i=1; i<101; i++) {
                            if(book.get(i).isEmpty()) continue;
                            sb.append(book.get(i).first()).append("\n");
                            break;
                        }
                    break;
                case "add":
                    P = sc.nextInt();
                    L = sc.nextInt();
                    for(int i=1; i<101; i++)
                        if(book.get(i).contains(P)) {
                            book.get(i).remove(P);
                            break;
                        }
                    book.get(L).add(P);
                    break;
                case "solved":
                    P = sc.nextInt();
                    for(int i=1; i<101; i++)
                        if(book.get(i).contains(P)) {
                            book.get(i).remove(P);
                            break;
                        }
                    break;

            }
        }
        sc.close();
        System.out.println(sb.toString());
    }

}
