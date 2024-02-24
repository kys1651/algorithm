import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static char[][][] color;
    static int[][][] effect;
    static int[] permutations = new int[3];
    static int[][] effectBoard = new int[5][5];
    static char[][] colorBoard = new char[5][5];
    static boolean[] visit;

    static int[] startX = {0, 0, 1, 1};
    static int[] startY = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        color = new char[N][4][4];
        effect = new int[N][4][4];

        // 재료 입력
        for (int i = 0; i < N; i++) {
            // effect Input
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    effect[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }// effect Input End.

            // color Input
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    color[i][j][k] = st.nextToken().charAt(0);
                }
            }// color Input End.
        }// 재료 입력 종료

        permutation(0);

        System.out.println(result);
    }


    private static void permutation(int depth) {
        if (depth == 3) {
            result = Math.max(calc(), result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            visit[i] = true;

            int[][] saveEffect = new int[5][5];
            char[][] saveColor = new char[5][5];
            saveEffect(effectBoard, saveEffect);
            saveColor(colorBoard, saveColor);

            for (int j = 0; j < 4; j++) {
                rotate(i);
                for (int k = 0; k < 4; k++) {
                    apply(startX[k], startY[k], i);
                    permutation(depth + 1);

                    saveEffect(saveEffect, effectBoard);
                    saveColor(saveColor, colorBoard);
                }
            }
            visit[i] = false;
        }
    }

    private static int calc() {
        int R = 0, B = 0, G = 0, Y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                switch (colorBoard[i][j]) {
                    case 'R':
                        R += effectBoard[i][j];
                        break;
                    case 'B':
                        B += effectBoard[i][j];
                        break;
                    case 'G':
                        G += effectBoard[i][j];
                        break;
                    case 'Y':
                        Y += effectBoard[i][j];
                        break;
                }
            }
        }
        return 7 * R + 5 * B + 3 * G + 2 * Y;
    }

    private static void apply(int x, int y, int idx) {
        int[][] e = effect[idx];
        char[][] c = color[idx];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (c[i][j] != 'W') {
                    colorBoard[x + i][y + j] = c[i][j];
                }

                effectBoard[x + i][y + j] += e[i][j];
                if (effectBoard[x + i][y + j] > 9) {
                    effectBoard[x + i][y + j] = 9;
                }
                if (effectBoard[x + i][y + j] < 0) {
                    effectBoard[x + i][y + j] = 0;
                }
            }
        }
    }

    private static void rotate(int idx) {
        char[][] tmpColor = new char[4][4];
        int[][] tmpEffect = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tmpColor[i][j] = color[idx][4 - j - 1][i];
                tmpEffect[i][j] = effect[idx][4 - j - 1][i];
            }
        }
        color[idx] = tmpColor;
        effect[idx] = tmpEffect;
    }

    private static void saveColor(char[][] from, char[][] to) {
        for (int i = 0; i < 5; i++) {
            to[i] = Arrays.copyOf(from[i], 5);
        }
    }

    private static void saveEffect(int[][] from, int[][] to) {
        for (int i = 0; i < 5; i++) {
            to[i] = Arrays.copyOf(from[i], 5);
        }
    }
}