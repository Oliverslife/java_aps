package chap00_Data_Structure;

import java.util.*;

public class b2800 {

    static String input;
    static StringBuilder sb = new StringBuilder();
    static List<int[]> comb = new ArrayList<>();
    static boolean[] selected;
    static Set<String> filter = new HashSet<>();
    static List<String> answer = new ArrayList<>();

    static void dfs(int depth) {

        if(depth == comb.size()) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i=0; i<selected.length; i++)
                if(selected[i]) {
                    pq.offer(comb.get(i)[0]);
                    pq.offer(comb.get(i)[1]);
                }
            if(pq.isEmpty())
                return;
            for(int i=0; i<input.length(); i++) {
                if(!pq.isEmpty() && i == pq.peek()) {
                    pq.poll();
                    continue;
                }
                sb.append(input.charAt(i));
            }
            filter.add(sb.toString());
            sb.setLength(0);
            return;
        }

        dfs(depth + 1);
        selected[depth] = true;
        dfs(depth + 1);
        selected[depth] = false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        input = sc.next();
        sc.close();

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == '(')
                stack.push(i);
            else if(input.charAt(i) == ')')
                comb.add(new int[] {stack.pop(), i});
        }

        selected = new boolean[comb.size()];
        dfs(0);

        for(String str : filter)
            answer.add(str);

        Collections.sort(answer);
        for(String str : answer)
            sb.append(str).append("\n");

        System.out.print(sb);

    }
}
