package chap01_Data_Structure_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b1620 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, String> numToName = new HashMap<>();
        Map<String, Integer> nameToNum = new HashMap<>();
        for(int i=1; i<=N; i++) {
            String name = sc.next();
            numToName.put(i, name);
            nameToNum.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            String input = sc.next();
            sb.append(nameToNum.containsKey(input) ? nameToNum.get(input) : numToName.get(Integer.parseInt(input))).append("\n");
        }
        sc.close();

        System.out.print(sb);
    }
}
