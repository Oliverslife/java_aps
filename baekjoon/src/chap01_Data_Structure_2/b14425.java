package chap01_Data_Structure_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class b14425 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> set = new HashSet<>();
        while(N-- > 0)
            set.add(sc.next());

        int ans = 0;
        while(M-- > 0)
            ans += set.contains(sc.next()) ? 1 : 0;
        sc.close();

        System.out.print(ans);

    }

}
