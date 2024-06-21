import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] hp, damage;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        hp = new long[N]; // 각 방에서 얻을 수 있는 치유
        damage = new long[N]; // 각 방에서 받는 피해

        long attack = Integer.parseInt(st.nextToken());
        long t, a, h, upper = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            // 몬스터 방인 경우
            if (t == 1) {
                long count = h / attack;
                if (h % attack == 0) count--;
                damage[i] = count * a;
                upper += damage[i];
            } else {
                attack += a;
                hp[i] = h;
            }
        }

        long lower = 1;
        while (lower < upper) {
            long mid = (lower + upper) >> 1;
            if (isCan(mid)) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        System.out.println(lower);
    }

    private static boolean isCan(long maxHp) {
        long h = maxHp;
        for (int i = 0; i < N; i++) {
            h -= damage[i];
            h += hp[i];
            if (h > maxHp) h = maxHp;
            if (h <= 0) return false;
        }
        return true;
    }
}