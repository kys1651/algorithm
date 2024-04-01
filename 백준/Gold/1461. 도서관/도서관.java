import java.util.*;
import java.io.*;

public class Main {
	static PriorityQueue<Integer> negative = new PriorityQueue<>((o1, o2) -> o1 - o2);
	static PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) -> o2 - o1);
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// Input
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp < 0)
				negative.add(tmp);
			else
				positive.add(tmp);
		} // Input End

		int maxNegative = getNegative();
		int maxPositive = getPositive();
		int answer = maxNegative + maxPositive;
		if(maxNegative > maxPositive) {
			answer = answer + maxPositive;
		}else {
			answer = answer + maxNegative;
		}
		
		while(true) {
			int negativeNum = getNegative();
			int positivieNum = getPositive();
			if(negativeNum == 0 && positivieNum == 0) {
				break;
			}
			answer = answer + negativeNum * 2 + positivieNum * 2;
		}
		
		
		System.out.println(answer);
	}

	private static int getNegative() {
		int count = 0, max = 0;
		while (!negative.isEmpty() && count < M) {
			count++;
			int tmp = negative.poll();
			if (Math.abs(tmp) > max)
				max = Math.abs(tmp);
		}
		return max;
	}

	private static int getPositive() {
		int count = 0,max=0;
		while(!positive.isEmpty() && count < M) {
			count++;
			int tmp = positive.poll();
			if (Math.abs(tmp) > max)
				max = Math.abs(tmp);
		}
		return max;
	}
}
