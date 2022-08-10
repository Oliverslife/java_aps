package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q1926 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
        for(int i=1; i<=N; i++) {
            String tmp = Integer.toString(i);
            if(tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
                for(int j=0; j<tmp.length(); j++) {
                    tmp = tmp.replaceAll("[369]", "-");
                }
                tmp = tmp.replaceAll("[0124578]", "");
            }
            System.out.print(tmp + " ");
        }       
        br.close();
	}

}
