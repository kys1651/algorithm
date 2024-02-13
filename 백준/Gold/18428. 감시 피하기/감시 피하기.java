import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 위치를 뜻하는 클래스
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static ArrayList<Point> emptyList = new ArrayList<>();
    static ArrayList<Point> teacher = new ArrayList<>();
    static char[][] map, copyMap;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        copyMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                copyMap[i][j] = map[i][j];

                Point point = new Point(i, j);
                if (map[i][j] == 'X') {
                    emptyList.add(point);
                } else if (map[i][j] == 'T') {
                    teacher.add(point);
                }
            }
        }

        combination(0, 0);

        System.out.println("NO");
    }

    // 장애물 3가지 조합을 만드는 메서드
    private static void combination(int depth, int at) {
        // 3개 설치 했다면 확인 해줌
        if (depth == 3) {
            // 학생이 안걸리는 경우 true
            if (isValid()) {
                System.out.print("YES");
                System.exit(0);
            }

            return;
        }

        for (int i = at; i < emptyList.size(); i++) {
            Point o = emptyList.get(i);
            map[o.x][o.y] = 'O';
            combination(depth + 1, i + 1);
            map[o.x][o.y] = 'X';
        }
    }

    private static boolean isValid() {
        // 선생님 사방 체크
        for (Point t : teacher) {
            // 학생 발견시 false
            if (!checkForward(t)) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkForward(Point t) {
        for (int i = 0; i < 4; i++) {
            int nX = t.x;
            int nY = t.y;
            // 배열 범위 내에 장애물이면
            while (isIn(nX, nY) && map[nX][nY] != 'O') {
                // 학생 발견시 유효하지 않음
                if (map[nX][nY] == 'S') {
                    return false;
                }
                nX += dirX[i];
                nY += dirY[i];
            }
        }

        return true;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}