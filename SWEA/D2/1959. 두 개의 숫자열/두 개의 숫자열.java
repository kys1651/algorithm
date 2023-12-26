import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] A = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] B = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }
			
            int result = 0;
            if(n < m){
                result = multiply(A,B);
            }else{
                result = multiply(B,A);
            }
            sb.append("#" + tc + " " + result).append("\n");
		}
        System.out.println(sb);
	}
    
	private static int multiply(int[] min, int[] max){
        int result = 0;
        int minLen = min.length;
        int maxLen = max.length;
        for(int i = 0; i <= maxLen - minLen; i++){
            int tmp = 0;
            for(int j = 0; j < minLen; j++){
                tmp += min[j] * max[i + j];
            }
            result = Math.max(result,tmp);
        }
        return result;
    }
}