package Selected_06_MST;

import java.io.*;

public class q1922_Prim_solving {

    static int[] p;     //대표를 저장할 배열

    static class Vertex {
        int no, weight;
        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        //간선의 정보를 저장해야겠다.


    }}
