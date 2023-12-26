import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution {
    static int[][] map;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
            map = new int[9][9];
            for(int i = 0; i < 9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#" + tc + " " + sudoku()).append("\n");
		}
        System.out.println(sb);
	}
    private static int sudoku(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(!check(i,j)){
                    return 0;
                }
            }
        }
        return 1;
    }
    private static boolean check(int x, int y){
        // 가로 세로 확인
        for(int i = 0; i < 9; i++){
            if(map[x][i] == map[x][y] && i != y) {
                return false;
            }
            if(map[i][y] == map[x][y] && i != x) {
                return false;
            }
        }
        
        // 분면 확인
        int checkX = (x / 3) * 3;
        int checkY = (y / 3) * 3;
        for(int i = checkX; i < checkX + 3; i++){
            for(int j = checkY; j < checkY + 3; j++){
                if(map[i][j] == map[x][y] && (i != x || j != y)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}