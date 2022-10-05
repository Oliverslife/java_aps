package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class q21278_solving {

    static int n, m;

    static class Node {
        int to;
        Node next;
        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bw.flush();
        bw.close();
        br.close();
    }
}
