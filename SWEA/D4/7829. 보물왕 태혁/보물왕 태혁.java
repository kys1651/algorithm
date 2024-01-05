import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
            int n = Integer.parseInt(br.readLine());
            // 서로 다른 자연수 P개를 담아 낼 배열
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 최소값과 최대값을 구해주기 위해서 정렬 해줌
            Arrays.sort(arr);
            // 최소값과 최대값을 곱하여 자연수를 구해준다.
            int answer = arr[0] * arr[n-1];
            sb.append("#" + tc + " " + answer).append("\n");
		}
		System.out.println(sb);
	}
}