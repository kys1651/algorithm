import java.io.*;
import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            String num = st.nextToken();
            int sum = 0;
            for(char ch : num.toCharArray()) sum += ch -'0';
            System.out.println("#" + tc + " " + (sum % n ));
		}
	}
}