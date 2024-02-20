import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int U = 0;
    static final int D = 1;
    static final int F = 2;
    static final int B = 3;
    static final int L = 4;
    static final int R = 5;

    static char[][][] cube;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            initCube();
            int N = Integer.parseInt(br.readLine());
            String[] commands = br.readLine().split(" ");
            for (String command : commands) {
                char idx = command.charAt(0);
                char dir = command.charAt(1);

                if (dir == '+') {
                    cw(idx);
                } else if (dir == '-') {
                    for (int i = 0; i < 3; i++) {
                        cw(idx);
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(cube[U][i][j]);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void cw(char ch) {
        if (ch == 'L') {
            rotateCw(cube[L]);
            // U면 0행 저장
            char a = cube[U][0][0];
            char b = cube[U][1][0];
            char c = cube[U][2][0];

            // B[2행] -> U[0행]
            insertRow(U, 0, cube[B][2][2], cube[B][1][2], cube[B][0][2]);
            // D[2행] -> B[2행]
            insertRow(B, 2, cube[D][0][2], cube[D][1][2], cube[D][2][2]);
            // F[0행] -> D[2행]
            insertRow(D, 2, cube[F][2][0], cube[F][1][0], cube[F][0][0]);
            // U -> F
            insertRow(F, 0, a, b, c);
        } else if (ch == 'R') {
            rotateCw(cube[R]);
            // U 2행 저장
            char a = cube[U][0][2];
            char b = cube[U][1][2];
            char c = cube[U][2][2];

            // F[2행] -> U[2행] (높,높)
            insertRow(U, 2, cube[F][0][2], cube[F][1][2], cube[F][2][2]);
            // D[0행] -> F[2행] (낮,높)
            insertRow(F, 2, cube[D][2][0], cube[D][1][0], cube[D][0][0]);
            // B[0행] -> D[0행] (높,높)
            insertRow(D, 0, cube[B][0][0], cube[B][1][0], cube[B][2][0]);
            // U[2행] -> B[0행] (낮,높)
            insertRow(B, 0, c, b, a);
        } else if (ch == 'F') {
            rotateCw(cube[F]);
            // U면 2열 저장
            char a = cube[U][2][0];
            char b = cube[U][2][1];
            char c = cube[U][2][2];

            // L[2행] -> U[2열] (높,낮)
            insertCol(U, 2, cube[L][2][2], cube[L][1][2], cube[L][0][2]);
            // D[2열] -> L[2행] (높,낮)
            insertRow(L, 2, cube[D][2][2], cube[D][2][1], cube[D][2][0]);
            // R[0행] -> D[2열] (낮,낮)
            insertCol(D, 2, cube[R][0][0], cube[R][1][0], cube[R][2][0]);
            // U[2열] -> R[0행]
            insertRow(R, 0, a, b, c);
        } else if (ch == 'B') {
            rotateCw(cube[B]);
            // U면 0열 저장
            char a = cube[U][0][0];
            char b = cube[U][0][1];
            char c = cube[U][0][2];

            // R[2행] -> U[0열] (낮,낮)
            insertCol(U, 0, cube[R][0][2], cube[R][1][2], cube[R][2][2]);
            // D[0열] -> R[2행] (높,높)
            insertRow(R, 2, cube[D][0][0], cube[D][0][1], cube[D][0][2]);
            // L[0행] -> D[0열] (낮,높)
            insertCol(D, 0, cube[L][2][0], cube[L][1][0], cube[L][0][0]);
            // U[0열] -> L[0행]
            insertRow(L, 0, c, b, a);
        } else if (ch == 'U') {
            rotateCw(cube[U]);
            // B면 0열 저장
            char a = cube[B][0][0];
            char b = cube[B][0][1];
            char c = cube[B][0][2];

            // L[0열] -> B[0열] (낮,낮)
            insertCol(B, 0, cube[L][0][0], cube[L][0][1], cube[L][0][2]);
            // F[0열] -> L[0열] (낮,낮)
            insertCol(L, 0, cube[F][0][0], cube[F][0][1], cube[F][0][2]);
            // R[0열] -> F[0열] (낮,낮)
            insertCol(F, 0, cube[R][0][0], cube[R][0][1], cube[R][0][2]);
            // B[0열] -> R[0열] (낮,낮)
            insertCol(R, 0, a, b, c);
        } else if (ch == 'D') {
            rotateCw(cube[D]);

            // B면 2열 저장
            char a = cube[B][2][0];
            char b = cube[B][2][1];
            char c = cube[B][2][2];

            // R[2열] -> B[2열] (낮,낮)
            insertCol(B, 2, cube[R][2][0], cube[R][2][1], cube[R][2][2]);
            // F[2열] -> R[2열] (낮,낮)
            insertCol(R, 2, cube[F][2][0], cube[F][2][1], cube[F][2][2]);
            // L[2열] -> F[2열] (낮,낮)
            insertCol(F, 2, cube[L][2][0], cube[L][2][1], cube[L][2][2]);
            // B[2열] -> L[2열] (낮,낮)
            insertCol(L, 2, a, b, c);
        }
    }

    private static void insertRow(int idx, int n, char a, char b, char c) {
        // cube n행에 a,b,c를 넣는다.
        cube[idx][0][n] = a;
        cube[idx][1][n] = b;
        cube[idx][2][n] = c;
    }

    // 열 회전
    private static void insertCol(int idx, int n, char a, char b, char c) {
        // cube에 n열에 cubeCol을 넣는다.
        cube[idx][n][0] = a;
        cube[idx][n][1] = b;
        cube[idx][n][2] = c;
    }

    private static void rotateCw(char[][] arr) {
        for (int i = 0; i < 2; i++) {
            char tmp = arr[0][0];
            arr[0][0] = arr[1][0];
            arr[1][0] = arr[2][0];
            arr[2][0] = arr[2][1];
            arr[2][1] = arr[2][2];
            arr[2][2] = arr[1][2];
            arr[1][2] = arr[0][2];
            arr[0][2] = arr[0][1];
            arr[0][1] = tmp;
        }
    }

    // 큐브 초기화
    private static void initCube() {
        cube = new char[6][9][9];
        // 윗면
        fillCube(U, 'w');
        // 아랫면
        fillCube(D, 'y');
        // 앞면
        fillCube(F, 'r');
        // 뒷면
        fillCube(B, 'o');
        // 왼쪽면
        fillCube(L, 'g');
        // 오른쪽면
        fillCube(R, 'b');
    }

    private static void fillCube(int idx, char mark) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cube[idx][i][j] = mark;
            }
        }
    }
}