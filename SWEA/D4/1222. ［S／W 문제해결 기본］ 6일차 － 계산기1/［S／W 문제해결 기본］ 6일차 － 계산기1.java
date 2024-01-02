import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine(),"+");
            int sum = 0;
            while(st.hasMoreTokens()){
                sum += Integer.parseInt(st.nextToken());
            }
            System.out.println("#" + tc + " " + sum);
		}
	}
}