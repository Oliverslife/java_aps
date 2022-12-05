package Selected_02_DataStructure;

import java.io.*;
import java.util.*;

public class q2800 {
    static class Pair {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        Stack<Integer> open = new Stack<>();
        List<Pair> pairs = new ArrayList<>();
        List<Integer> tmp;
        Set<String> filter = new HashSet<>();
        List<String> ans = new ArrayList<>();

        String target = br.readLine();
        for(int i=0; i<target.length(); i++) {
            if(target.charAt(i) == '(')
                open.push(i);
            else if(target.charAt(i) == ')')
                pairs.add(new Pair(open.pop(), i));
        }

        for(int i=1; i< 1<<pairs.size(); i++) {
            sb = new StringBuilder(target);
            tmp = new ArrayList<>();
            for(int j=0; j<pairs.size(); j++) {
                if((i & (1 << j)) != 0) {
                    tmp.add(pairs.get(j).start);
                    tmp.add(pairs.get(j).end);
                }
            }

            Collections.sort(tmp, Collections.reverseOrder());
            for(int x : tmp)
                sb.deleteCharAt(x);
            filter.add(sb.toString());
        }
        for(String str : filter)
            ans.add(str);

        Collections.sort(ans);
        for(String str : ans)
            bw.write(str + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
