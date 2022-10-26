package Selected_05_GraphTraversal;

import java.util.Arrays;
import java.util.Scanner;

public class q1504_solving {
    static int V, E;
    static Node[] nodes;
    static class Node implements Comparable<Node> {
        int to, weight;
        Node next;
        public Node(int to, int weight, Node next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        nodes = new Node[V];
        while(E-- > 0) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int weight = sc.nextInt();
            nodes[from] = new Node(to, weight, nodes[from]);
            nodes[to] = new Node(from, weight, nodes[to]);
        }

        int[] dist = new int[V];
        Arrays.fill(dist, 0);

    }
}
