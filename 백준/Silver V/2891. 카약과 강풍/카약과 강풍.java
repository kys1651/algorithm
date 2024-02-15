import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] team = new int[12];
		Arrays.fill(team, 1);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			team[Integer.parseInt(st.nextToken())]--;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			team[Integer.parseInt(st.nextToken())]++;
		}

		for (int i = 1; i <= N; i++) {
			if (team[i] == 0 && team[i - 1] == 2) {
				team[i]++;
				team[i - 1]--;
			}
			if (team[i] == 0 && team[i + 1] == 2) {
				team[i]++;
				team[i + 1]--;
			}
		}
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(team[i] == 0) answer++;
		}
		System.out.println(answer);
	}
}
