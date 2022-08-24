//package Chap15_백트래킹;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class q15650 {
//
//    static boolean[] visited;
//    static int[] arr;
//    static StringBuilder sb = new StringBuilder();
//
//    static void dfs(int n, int m, int depth) throws IOException {
//
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        arr = new int[m];
//        visited = new boolean[n];
//        dfs(n, m, 0);
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}
