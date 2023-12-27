import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ").append("\n");
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            rotation(map);
		}
        System.out.println(sb);
	}
    private static void rotation(int[][] map){
        int len = map.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                sb.append(map[len - 1 - j][i]);
            }
            sb.append(" ");
            for(int j = 0; j < len; j++){
                sb.append(map[len - 1 - i][len - 1 - j]);
            }
            sb.append(" ");
            for(int j = 0; j < len; j++){
                sb.append(map[j][len - 1 - i]);
            }
            sb.append("\n");
        }
    }
}