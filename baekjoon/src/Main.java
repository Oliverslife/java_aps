import java.io.*;
import java.util.StringTokenizer;

/**
 * solving...
 */
public class Main {

    public static int stoi(String str) { return Integer.parseInt(str); }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int d = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int c = stoi(st.nextToken());

        bw.write();

        bw.flush();
        bw.close();
        br.close();
    }
}