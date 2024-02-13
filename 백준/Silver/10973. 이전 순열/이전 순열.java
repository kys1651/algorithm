import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(!pp(arr)) {
			sb.append(-1);
		}else {
			for(int a : arr) {
				sb.append(a).append(' ');
			}
		}
		System.out.println(sb);
	}
	
	private static boolean pp(int[] p) {
		int i = p.length - 1;
		while(i - 1 >= 0 && p[i-1] <= p[i]) {
			i--;
		}
		
		if(i == 0) {
			return false;
		}
		
		int max = i;
		for(int j = i; j < p.length; j++) {
			if(p[i-1] > p[j] && p[max] < p[j]) {
				max = j;
			}
		}

		swap(p,i-1,max);
		int j = p.length - 1;
		while(i < j) {
			swap(p,i++,j--);
		}
		return true;
	}
	
	private static void swap(int[] p, int i , int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
}
