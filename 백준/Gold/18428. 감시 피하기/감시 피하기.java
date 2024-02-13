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
    static ArrayList<Point> student = new ArrayList<>();
    static Point[] obstacle = new Point[3];
    static char[][] map, copyMap;
    static boolean[][] visit;

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
                } else {
                    student.add(point);
                }
            }
        }

        combination(0, 0);

        System.out.println("NO");
    }

    private static void combination(int depth, int at) {
        if (depth == 3) {
            if (isValid()) {
                System.out.print("YES");
                System.exit(0);
            }

            for (int i = 0; i < N; i++) {
                map[i] = Arrays.copyOf(copyMap[i], N);
            }

            return;
        }

        for (int i = at; i < emptyList.size(); i++) {
            obstacle[depth] = emptyList.get(i);
            combination(depth + 1, i + 1);
        }
    }

    private static boolean isValid() {
        installObstacle();
        visit = new boolean[N][N];

        // 선생님 사방 체크
        for (Point t : teacher) {
            if(!checkForward(t)){
                return false;
            }
        }

//        // 학생 걸림
//        for (Point s : student) {
//            if (visit[s.x][s.y]) {
//                return false;
//            }
//        }

        return true;
    }

    private static boolean checkForward(Point t) {
        for (int i = 0; i < 4; i++) {
            int nX = t.x;
            int nY = t.y;
            // 배열 범위 내에 장애물이면
            while (isIn(nX, nY) && map[nX][nY] != 'O') {
                // 학생 발견시 유효하지 않음
                if(map[nX][nY] == 'S'){
                    return false;
                }
                visit[nX][nY] = true;
                nX += dirX[i];
                nY += dirY[i];
            }
        }

        return true;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static void installObstacle() {
        // 장애물 설치
        for (int i = 0; i < 3; i++) {
            Point o = obstacle[i];
            map[o.x][o.y] = 'O';
        }
    }
}