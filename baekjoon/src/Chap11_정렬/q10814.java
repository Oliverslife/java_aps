package Chap11_정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q10814 {
    static class target implements Comparable<target> {
        int age;
        String name;
        int cnt;

        public target(int age, String name, int cnt) {
            this.age = age;
            this.name = name;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return this.age + " " + this.name;
        }

        @Override
        public int compareTo(target o) {
            if(this.age == o.age)
                return this.cnt - o.cnt;
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<target> list = new ArrayList<>();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new target(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }
        Collections.sort(list);

        for(target t : list) {
            bw.write(t + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}