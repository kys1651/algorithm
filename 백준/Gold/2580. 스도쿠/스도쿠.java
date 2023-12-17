import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class EmptyPoint{
        int x;
        int y;

        public EmptyPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map = new int[9][9];
    static ArrayList<EmptyPoint> empty = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    empty.add(new EmptyPoint(i, j));
                }
            }
        }
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == empty.size()) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        EmptyPoint pos = empty.get(depth);
        for (int i = 1; i <= 9; i++) {
            if (validationNumber(i, pos)) {
                map[pos.x][pos.y] = i;
                dfs(depth + 1);
                map[pos.x][pos.y] = 0;
            }
        }
    }

    private static boolean validationNumber(int value, EmptyPoint pos) {
        // 가로 줄, 세로 줄에 value값이 존재하는지 확인
        for(int i = 0; i < 9; i++){
            if (map[pos.x][i] == value || map[i][pos.y] == value) {
                return false;
            }
        }

        // 해당 위치 3 x 3 위치에 value값이 있는지 확인해줌
        int x = (pos.x / 3) * 3;
        int y = (pos.y / 3) * 3;
        for(int i = x; i < x + 3; i++){
            for(int j = y; j < y + 3; j++){
                if(map[i][j] == value){
                    return false;
                }
            }
        }

        return true;
    }
}
