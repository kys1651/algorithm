import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] switchArr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		switchArr = new boolean[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int idx = Integer.parseInt(st.nextToken());
			switchArr[i] = idx == 1 ? true : false;
		}
		
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				switchMan(idx);
			}else {
				switchWoman(idx);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i =1 ; i <= n; i++) {
			sb.append(switchArr[i] ? 1 : 0).append(" ");
			if(i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void switchMan(int idx) {
		for(int i = idx; i <= n; i+= idx) {
			switchArr[i] = !switchArr[i];
		}
	}
	
	private static void switchWoman(int idx) {
		int l = idx, r = idx;
		while(l - 1 >= 1 && r + 1 <= n && switchArr[l-1] == switchArr[r+1]) {
			l--; r++;
		}
		for(; l <= r; l++) {
			switchArr[l] = !switchArr[l];
		}
	}

}
