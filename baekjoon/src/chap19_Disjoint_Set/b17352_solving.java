package chap19_Disjoint_Set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class b17352_solving {

    static int N;
    static int[] p;

    static void make() {
        p = new int[N + 1];
        for (int i=0; i<=N; i++)
            p[i] = i;
    }

    static int find(int a) {
        if (p[a] == a)
            return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b) {
        int ar = p[a];
        int br = p[b];
        if (ar == br)
            return false;
        p[br] = ar;
        return true;
    }

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        make();
        for (int i=0; i<N-2; i++)
            union(sc.nextInt(), sc.nextInt());
        sc.close();

        for (int i=1; i<=N; i++)
            set.add(find(i));

        for (int i : set)
            System.out.print(i + " ");

    }
}
