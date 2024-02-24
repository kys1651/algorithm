import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Stack<Point>[] stack;
    static char[][] map;
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // Stack 초기화
        stack = new Stack[C + 1];
        for (int i = 1; i <= C; i++) {
            stack[i] = new Stack<>();
        }

        // input
        map = new char[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String input = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = input.charAt(j - 1);
            }
        }// input End

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int pos = Integer.parseInt(br.readLine());

            // 경로 중 유효하지 않는 공간(돌이 위치한 공간)이 나온다면 빼준다.
            while (!stack[pos].isEmpty() && map[stack[pos].peek().x][stack[pos].peek().y] == 'O') {
                stack[pos].pop();
            }

            // 비었다면 처음부터 시뮬레이션
            if (stack[pos].isEmpty()) {
                stoneThrow(1, pos, pos);
            }
            // 비지 않았다면 유효한 위치(가장 가까운 위치)에서 시뮬레이션
            else {
                stoneThrow(stack[pos].peek().x, stack[pos].peek().y, pos);
            }
        }

        // Output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
        // Output End
    }

    // 돌 던지기 시뮬레이션
    private static void stoneThrow(int x, int y, int pos) {
        // 벽을 만나거나 끝가지 갈 때 까지 진행
        while (x + 1 <= R && map[x + 1][y] != 'X') {
            // 돌을 만나면
            if (map[x + 1][y] == 'O') {

                // 왼쪽으로 갈 수 있는지 확인
                // 돌 기준 왼쪽이 범위 내이고 && 돌의 왼쪽이 비어있고 && 현재 위치 왼쪽이 비어있다면
                if (isIn(x + 1, y - 1) && map[x + 1][y - 1] == '.' && map[x][y - 1] == '.') {
                    // 왼쪽으로 좌표를 옮겨준다.
                    x++;
                    y--;
                }
                // 오른쪽으로 갈 수 있는지 확인
                // 돌 기준 오른쪽이 범위내 && 돌의 오른쪽이 비어있고 && 현재 위치 오른쪽이 비어있다면
                else if (isIn(x + 1, y + 1) && map[x + 1][y + 1] == '.' && map[x][y + 1] == '.') {
                    // 오른쪽으로 좌표를 옮겨준다.
                    x++;
                    y++;
                }
                // 아무곳도 갈 수 없다면 현재 위치에 저장해야한다.
                else {
                    break;
                }
            }
            // 돌을 만나지 않는다면 계속 내려간다.
            else {
                x++;

            }
            // 경로를 계속 저장해준다.
            stack[pos].push(new Point(x, y));
        }
        // 마지막에 위치한 x,y위치에 돌을 저장한다.
        map[x][y] = 'O';
    }

    // x,y가 돌이 위치할 수 있는지 확인
    private static boolean isIn(int x, int y) {
        return x > 0 && x <= R && y > 0 && y <= C;
    }
}
