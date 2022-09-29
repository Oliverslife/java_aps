//package Selected_04_BruteForce;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class q16637_solving {
//    static int n, ans = 0;
//    static List<Integer> nums = new ArrayList<>();      // nums.size()는 ops.size() 보다 1 더 클 것.
//    static List<Character> ops = new ArrayList<>();
//    static void dfs(int depth, int now) {
//        if(depth == ops.size()) {
//            ans = Math.max(ans, now);
//            return;
//        }
//        //괄호 고려없이 순차진행 [1 > 2 순서]
//        int tmp = do_Op(now, nums.get(depth + 1), ops.get(depth));  //지금 값과 다음 값을 연산
//        dfs(depth + 1, tmp);
//
//        //다음 연산을 미리 계산 후 현재 값과 연산 [2 > 1 순서]
//        if(depth < nums.size()) {
//            tmp = do_Op(nums.get(depth + 1), nums.get(depth + 2), ops.get(depth + 1));
//            dfs(depth + 2, do_Op(now, tmp, ops.get(depth)));
//        }
//
//    }
//
//    static int do_Op(int a, int b, char op) {
//        switch(op) {
//            case '+':
//                return a + b;
//            case '-':
//                return a - b;
//            case '*':
//                return a * b;
//            default:
//                return 0;
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//
//        n = Integer.parseInt(br.readLine());
//        for(char ch : br.readLine().toCharArray()) {
//            if(ch == '+' || ch == '-' || ch == '*')
//                ops.add(ch);
//            else
//                nums.add(Character.getNumericValue(ch));
//        }
//
//        dfs(1, nums.get(0));
//
//        bw.write(ans + "");
//        bw.flush();
//        bw.close();
//        br.close();
//
//    }
//}
