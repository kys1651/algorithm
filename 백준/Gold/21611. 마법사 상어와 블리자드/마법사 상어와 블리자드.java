import java.util.*;
import java.io.*;

public class Main {
    // 배열 크기
    static int N, sX, sY;

    // 맵 배열
    static int[][] map;
    static int[] result = new int[4];
    // 좌,하,우,상
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {-1, 0, 1, 0};

    // 배열에 넣기 위한 큐
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        sX = sY = N / 2;

        // Map Input
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j * 2) - '0';
            }
        }// Map Input End

        // Magic Input
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int magicDir = Integer.parseInt(st.nextToken()) - 1;
            int magicDist = Integer.parseInt(st.nextToken());
            switch (magicDir) {
                case 0:
                    magicDir = 3;
                    break;
                case 2:
                    magicDir = 0;
                    break;
                case 3:
                    magicDir = 2;
                    break;
            }
            magicShoot(magicDir, magicDist);
            explosion();
            change();
        }// Magic Input End

        int answer = 0;
        for (int i = 1; i <= 3; i++) {
            answer += result[i] * i;
        }
        System.out.println(answer);
    }

    private static void change(){
        getRoute();
        Queue<Integer> tmp = new LinkedList<>();
        int color = 0, count = 0;
        while (!queue.isEmpty()) {
            int curColor = queue.poll();
            if (color != curColor) {
                tmp.add(count);
                tmp.add(color);
                color = curColor;
                count = 1;
            } else {
                count++;
            }
        }
        tmp.add(count);
        tmp.add(color);
        tmp.poll(); tmp.poll();
        queue = tmp;
        addBall();
    }

    private static void explosion() {
        getRoute();
        Queue<Integer> tmp = new LinkedList<>();
        int size = queue.size();
        int color = 0, count = 0;
        while (!queue.isEmpty()) {
            int curColor = queue.poll();
            if (color != curColor) {
                if (count < 4) {
                    for (int i = 0; i < count; i++) {
                        tmp.add(color);
                    }
                }else {
                    result[color] += count;
                }
                color = curColor;
                count = 1;
            } else {
                count++;
            }
        }
        // 마지막 값 또한 tmp에 넣어줌
        if (count < 4) {
            for (int i = 0; i < count; i++) {
                tmp.add(color);
            }
        }else{
            result[color] += count;
        }

        // 같지 않다면 폭발하는 구슬이 없는 경우
        // 맵에 넣어준 뒤 연쇄 작용
        if (size != tmp.size()) {
            queue = tmp;
            addBall();
            explosion();
        }
    }

    private static void magicShoot(int d, int dist) {
        int nX = sX, nY = sY;
        for (int i = 0; i < dist; i++) {
            nX += dirX[d];
            nY += dirY[d];
            map[nX][nY] = 0;
        }
        getRoute();
        addBall();
    }

    private static void getRoute() {
        int x = sX, y = sY;
        int minus = sX - 1, limit = 1, d = 0;
        while (!(x == 0 && y == 0)) {
            int nX = x + dirX[d];
            int nY = y + dirY[d];
            if (isIn(nX, nY, limit)) {
                x = nX;
                y = nY;
                if (map[x][y] != 0) {
                    queue.offer(map[x][y]);
                }
                if (x == y && x == minus) {
                    minus--;
                    limit++;
                }
            } else {
                d = (d + 1) % 4;
            }
        }
    }

    private static void addBall() {
        int x = sX, y = sY;
        int minus = sX - 1, limit = 1, d = 0;
        while (!(x == 0 && y == 0)) {
            int nX = x + dirX[d];
            int nY = y + dirY[d];
            if (isIn(nX, nY, limit)) {
                x = nX;
                y = nY;
                if (queue.isEmpty()) {
                    map[x][y] = 0;
                } else {
                    map[x][y] = queue.poll();
                }
                if (x == y && x == minus) {
                    minus--;
                    limit++;
                }
            } else {
                d = (d + 1) % 4;
            }
        }
        queue.clear();
    }

    private static boolean isIn(int x, int y, int limit) {
        if (x > sX + limit || x < sX - limit) return false;
        if (y > sY + limit || y < sY - limit) return false;
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
