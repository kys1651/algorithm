import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, result;
    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point> house = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                // 집
                if (value == 1) {
                    house.add(new Point(i, j));
                }
                // 치킨집
                else if (value == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        // 치킨집 사이즈만큼 배열 생성 -> M개를 뽑아주기 위해서
        visit = new boolean[chicken.size()];
        result = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(result);
    }

    // M개의 치킨집을 뽑는 메서드
    private static void dfs(int depth, int pos) {
        // M를 뽑아준 뒤 계산해준다.
        if (depth == m) {
            calc();
            return;
        }
        // pos부터 하는 이유는 M개를 뽑을거니까 0에서부터 할 필요없고 전에 뽑은 치킨집을 또 뽑을 일 없음
        for (int i = pos; i < chicken.size(); i++) {
            if (visit[i]) continue;

            visit[i] = true;
            dfs(depth + 1, i + 1);
            visit[i] = false;
        }
    }

    // 치킨 거리를 구해주는 함수
    private static void calc() {
        int sumDistance = 0;
        for (Point h : house) {
            int distance = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (!visit[i]) continue;

                Point c = chicken.get(i);
                distance = Math.min(distance, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
            }
            sumDistance += distance;
        }
        result = Math.min(sumDistance, result);
    }
}
