import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map = new char[30000][31];

    static int R, C;
    static Pair[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // Input
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }// Input End

        memory = new Pair[C];

        for (int i = 0; i < C; i++) {
            memory[i] = new Pair(); // 생성자
            memory[i].col[0] = i; // 처음 시작 위치는 본인
            memory[i].update();
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int pos = Integer.parseInt(br.readLine()) - 1;
            memory[pos].insert();
            for (int j = 0; j < C; j++) {
                memory[j].update();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.println(sb);
    }

    static class Pair {
        int r; // 현재 경로의 행
        int[] col; // 경로의 열

        public Pair() {
            this.r = 1;
            this.col = new int[30000];
        }

        public void insert() {
            map[r - 1][col[r - 1]] = 'O';
        }

        public void update() {
            while (true) {
                int cur = col[r - 1];

                if (r > 1 && map[r - 1][cur] != '.') {
                    r--;
                } else if (r == R) {
                    break;
                } else if (map[r][cur] == 'X') {
                    break;
                } else if (map[r][cur] == '.') {
                    col[r] = cur;
                    r++;
                } else {
                    if (cur > 0 && map[r][cur - 1] == '.' && map[r - 1][cur - 1] == '.') {
                        col[r] = cur - 1;
                        r++;
                    } else if (cur + 1 < C && map[r][cur + 1] == '.' && map[r - 1][cur + 1] == '.') {
                        col[r] = cur + 1;
                        r++;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
