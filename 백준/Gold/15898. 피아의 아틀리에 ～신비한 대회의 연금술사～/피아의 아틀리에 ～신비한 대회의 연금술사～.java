import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static char[][][] color;
    static int[][][] effect;
    static int[] combinations = new int[3];
    static int[] permutations = new int[3];
    static int[][] start = new int[3][2];
    static boolean[] visit = new boolean[3];

    static int[] startX = {0, 0, 1, 1};
    static int[] startY = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
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

//        print(color[1]);
//        rotateColor(color[1], 1);
//        print(color[1]);
//        rotateColor(color[1], 1);
//        print(color[1]);

        // N개중 3개 뽑아내기
        combination(0, 0);

        System.out.println(result);
    }

    private static void print(char[][] arr) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // N개중 3개를 뽑아낸다.
    private static void combination(int depth, int at) {
        if (depth == 3) {
            permutation(0);
            return;
        }

        for (int i = at; i < N; i++) {
            combinations[depth] = i;
            combination(depth + 1, i + 1);
        }
    }

    private static void permutation(int depth) {
        if (depth == 3) {
            calc();
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            int idx = combinations[i];
            permutations[depth] = idx;
            for (int j = 0; j < 4; j++) {
                rotateColor(color[idx], idx);
                rotateEffect(effect[idx], idx);
                for (int k = 0; k < 4; k++) {
                    start[depth][0] = startX[k];
                    start[depth][1] = startY[k];
                    permutation(depth + 1);
                }
            }
            visit[i] = false;
        }
    }

    private static void calc() {
        int[][] effectMap = new int[5][5];
        char[][] colorMap = new char[5][5];

        for (int i = 0; i < 3; i++) {
            int idx = permutations[i];
            int startX = start[i][0];
            int startY = start[i][1];

            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    int nX = startX + x;
                    int nY = startY + y;
                    effectMap[nX][nY] += effect[idx][x][y];
                    if (effectMap[nX][nY] < 0) {
                        effectMap[nX][nY] = 0;
                    } else if (effectMap[nX][nY] > 9) {
                        effectMap[nX][nY] = 9;
                    }
                    if (color[idx][x][y] != 'W') {
                        colorMap[nX][nY] = color[idx][x][y];
                    }
                }
            }
        }

        int tmp = getResult(effectMap, colorMap);
        if (result < tmp) {
            result = tmp;
        }

    }

    private static int getResult(int[][] effectMap, char[][] colorMap) {
        int R = 0, B = 0, G = 0, Y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                switch (colorMap[i][j]) {
                    case 'R':
                        R += effectMap[i][j];
                        break;
                    case 'B':
                        B += effectMap[i][j];
                        break;
                    case 'G':
                        G += effectMap[i][j];
                        break;
                    case 'Y':
                        Y += effectMap[i][j];
                        break;
                }
            }
        }
        int tmp = 7 * R + 5 * B + 3 * G + 2 * Y;
        return tmp;
    }

    private static void rotateEffect(int[][] arr, int idx) {
        int[][] tmp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tmp[i][j] = arr[4 - j - 1][i];
            }
        }
        effect[idx] = tmp;
    }

    private static void rotateColor(char[][] arr, int idx) {
        char[][] tmp = new char[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tmp[i][j] = arr[4 - j - 1][i];
            }
        }
        color[idx] = tmp;
    }
}