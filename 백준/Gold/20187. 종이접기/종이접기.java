import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] command;
    static int[][] paper;
    static int N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[1 << 10][1 << 10];
        command = new char[N * 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            command[i] = st.nextToken().charAt(0);
        }

        H = Integer.parseInt(br.readLine());

        solve(0, 1, 1 << N, 1, 1 << N);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= (1 << N); i++) {
            for (int j = 1; j <= (1 << N); j++) {
                sb.append(paper[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void solve(int idx, int i1, int i2, int j1, int j2) {
        if (idx == command.length) {
            paper[i1][j1] = H;
            return;
        }
        // 위인 경우
        if (command[idx] == 'U') {
            // 윗 부분을 먼저 접는다.
            solve(idx + 1, i1, (i1 + i2) / 2, j1, j2);

            // 아래 부분은 윗 부분과 대칭이다.
            for (int i = (i1 + i2) / 2 + 1; i <= i2; i++) {
                for (int j = j1; j <= j2; j++) {
                    paper[i][j] = convert(paper[(i1 + i2) - i][j], 0);
                }
            }
        } else if (command[idx] == 'D') {
            solve(idx + 1, (i1 + i2) / 2 + 1, i2, j1, j2);

            for (int i = i1; i <= (i1 + i2) / 2; i++) {
                for (int j = j1; j <= j2; j++) {
                    paper[i][j] = convert(paper[(i1 + i2) - i][j], 0);
                }
            }
        } else if (command[idx] == 'R') {
            solve(idx + 1, i1, i2, (j1 + j2) / 2 + 1, j2);

            for (int i = i1; i <= i2; i++) {
                for (int j = j1; j <= (j1 + j2) / 2; j++) {
                    paper[i][j] = convert(paper[i][(j1 + j2) - j], 1);
                }
            }
        } else {
            solve(idx + 1, i1, i2, j1, (j1 + j2) / 2);

            for (int i = i1; i <= i2; i++) {
                for (int j = (j1 + j2) / 2 + 1; j <= j2; j++) {
                    paper[i][j] = convert(paper[i][(j1 + j2) - j], 1);
                }
            }
        }
    }

    private static int convert(int val, int k) {
        if (k == 0) {
            switch (val) {
                case 0:
                    return 2;
                case 1:
                    return 3;
                case 2:
                    return 0;
                default:
                    return 1;
            }
        } else {
            switch (val) {
                case 0:
                    return 1;
                case 1:
                    return 0;
                case 2:
                    return 3;
                default:
                    return 2;
            }
        }
    }
}
