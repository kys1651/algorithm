import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;        
        int[] num;
        
        int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
            br.readLine();
            num = new int[101];

            st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 1000; i++){
                int idx = Integer.parseInt(st.nextToken());
                num[idx]++;
            }
            int max = 0;
            for(int i = 1; i < num.length; i++){
                if(num[max] <= num[i]){
                    max = i;
                }
            }
            sb.append("#" + tc + " " + max).append("\n");
		}
        System.out.println(sb);
	}
}