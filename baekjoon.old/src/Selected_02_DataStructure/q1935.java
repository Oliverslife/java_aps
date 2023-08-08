package Selected_02_DataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class q1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Double> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        char tmp = 'A';
        double a, b;

        int n = Integer.parseInt(br.readLine());
        String target = br.readLine();
        for (int i = 0; i < n; i++)
            map.put(tmp++, Double.parseDouble(br.readLine()));

        for (char ch : target.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z')
                stack.push(map.get(ch));
            else {
                b = stack.pop();
                a = stack.pop();

                switch (ch) {
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                }
            }
        }
        bw.write(String.format("%.2f", stack.pop()) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
