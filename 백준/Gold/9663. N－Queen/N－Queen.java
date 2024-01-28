import java.util.*;
import java.io.*;

public class Main {
    static int result,n;
    static int[] map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n];
        visit = new boolean[n];

        searchCanQueen(0);

        System.out.println(result);
    }

    private static void searchCanQueen(int depth) {
        if (depth == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 방문한 곳이라면 -> 해당 숫자는 삽입이 불가능함.(이미 해당 열에는 퀸이 존재하기 때문에)
            if(visit[i]) continue;

            // 대각선이 유효하지 않다면 넘어감.
            if(!possible(depth,i)) continue;

            visit[i] = true;
            map[depth] = i;
            searchCanQueen(depth + 1);
            visit[i] = false;
        }
    }

    private static boolean possible(int depth, int idx) {
        for (int i = 0; i < depth; i++) {
            // 대각선에 존재하는지 확인
            if (Math.abs(i - depth) == Math.abs(map[i] - idx)) {
                return false;
            }
        }
       // 가능한 경우
        return true;
    }
}