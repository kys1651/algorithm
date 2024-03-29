import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N,result; // 배열의 크기 N x N
    static char[][] map; // 원본 맵

    // 시계순으로 설치해야한다.(위에서부터 아래로)
    static int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N < 3){
            System.out.println(0);
            return;
        }

        // Input
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        result = (N - 2) * (N - 2);
        // 테두리에만 숫자가 있음
        for (int i = 0; i < N; i++) {
            mineRemove(0, i, map[0][i] - '0');
            mineRemove(N - 1, i, map[N - 1][i] - '0');
            mineRemove(i, 0, map[i][0] - '0');
            mineRemove(i, N - 1, map[i][N - 1] - '0');
        }

        // # 위치에도 설치가 될 수 있다.
//        int answer = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (map[i][j] == '*' || map[i][j] == '#') {
//                    answer++;
//                }
//            }
//        }

        System.out.println(result);
    }

    private static void mineRemove(int x, int y, int count) {
        for (int i = 0; i < 8; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            // 배열 범위 밖이면 넘어간다.
            if (nX < 0 || nY < 0 || nX >= N || nY >= N) {
                continue;
            }

            // 설치 할 수 있는 곳이라면 설치
            if (map[nX][nY] == '#' && count != 0) {
                count--;
                map[nX][nY] = '*';
            }
            // 지뢰가 있다면 카운트 감소
            else if (map[nX][nY] == '*' && count != 0) {
                count--;
            }
            // 지뢰를 설치 할 수 없는 곳이라면 삭제
            else if (map[nX][nY] == '#' && count == 0) {
                map[nX][nY] = '-';
                result--;
            }
        }
    }
}