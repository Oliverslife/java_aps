package d2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q1986 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int ans;
		int tmp;
		for(int i=1; i<=T; i++) {	
			ans = 0;
			tmp = Integer.parseInt(br.readLine());
			for(int j=1; j<=tmp; j++) {
				if(j % 2 != 0)
					ans += j;
				else
					ans -= j;
			}
			bw.write(String.format("#%d %d", i, ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

    public static class q1208 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            List<Integer> list = new ArrayList<>();
            StringTokenizer st;
            for(int i=1; i<=10; i++) {
                list.clear();
                int n = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()) {
                    list.add(Integer.parseInt(st.nextToken()));
                }
                Collections.sort(list);
                for(int j=0; j<n; j++) {
                    list.set(list.size()-1, list.get(list.size()-1) - 1);
                    list.set(0, list.get(0) + 1);
                    Collections.sort(list);
                }
                bw.write("#" + i + " " + (list.get(list.size()-1) - list.get(0)) + "\n");
            }
            bw.flush();
            bw.close();
            br.close();
        }
    }

    public static class q1206 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            List<Integer> list = new ArrayList<>();
            StringTokenizer st;

            int ans;
            int width;
            int r1, r2, l1, l2;

            for(int i=0; i<10; i++) {
                list.clear();
                ans = 0;
                width = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()) {
                    list.add(Integer.parseInt(st.nextToken()));
                }
                for(int j=2; j<width-2; j++) {
                    r1 = list.get(j) - list.get(j+1);
                    r2 = list.get(j) - list.get(j+2);
                    l1 = list.get(j) - list.get(j-1);
                    l2 = list.get(j) - list.get(j-2);
                    if(r1 > 0 && r2 > 0 && l1 > 0 && l2 > 0)
                        ans += Math.min(Math.min(r1, r2), Math.min(l1, l2));
                }
                bw.write(String.format("#%d %d", i+1, ans));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();
        }
    }

    public static class q1210 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            int[][] lad;
            int x = 0;
            int y = 0;

            for(int i=1; i<=10; i++) {
                int n = Integer.parseInt(br.readLine());
                lad = new int[100][102];
                for(int j=0; j<100; j++) {
                    st = new StringTokenizer(br.readLine());
                    for(int k=1; k<101; k++) {
                        lad[j][k] = Integer.parseInt(st.nextToken());
                        if(lad[j][k] == 2) {
                            x = j;
                            y = k;
                        }
                    }
                }

                while(x != 0) {
                    if(lad[x][y-1] == 0 && lad[x][y+1] == 0) {
                        x--;
                    }
                    else if(lad[x][y-1] == 1) {
                        while(lad[x][y-1] == 1) {
                            y--;
                        }
                        x--;
                    }
                    else if(lad[x][y+1] == 1) {
                        while(lad[x][y+1] == 1) {
                            y++;
                        }
                        x--;
                    }
                }

                bw.write(String.format("#%d %d", n, y-1));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();
        }
    }
}
