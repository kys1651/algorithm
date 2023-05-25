import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
    }

    private static void sudoku(int row, int col) {
        if(col == 9){
            sudoku(row + 1, 0);
            return ;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                // 값 들어갈 수 있는지 검사
                if (check(row, col, i)) {
                    map[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            map[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);

    }

    private static boolean check(int row, int col, int value) {

        // 행 체크
        for (int i = 0; i < 9; i++) {
            if(map[row][i] == value) {
                return false;
            }
        }

        // 열 체크
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == value) {
                return false;
            }
        }

        int rowCheck = (row / 3) * 3;
        int colCheck = (col / 3) * 3;

        for (int i = rowCheck; i < rowCheck + 3; i++) {
            for (int j = colCheck; j < colCheck + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
