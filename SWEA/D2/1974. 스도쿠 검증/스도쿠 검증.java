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
        boolean[] visit1,visit2;
        // 한번에 가로 세로 확인하기
        for(int i = 0; i < 9; i++){
            visit1 = new boolean[10];
            visit2 = new boolean[10];
            for(int j = 0; j < 9; j++){
                int value1 = map[i][j];
                int value2 = map[j][i];
                if(visit1[value1] || visit2[value2]) return 0;
                visit1[value1] = visit2[value2] = true;            
            }
        }
        // 분면 확인하기
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!check(i * 3, j * 3))
                    return 0;
            }
        }
        return 1;
    }

    private static boolean check(int x, int y){
        boolean[] visit = new boolean[10];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int value = map[i][j];
                if(visit[value]) return false;
                else visit[value] = true;
            }
        }
        return true;
    }
}