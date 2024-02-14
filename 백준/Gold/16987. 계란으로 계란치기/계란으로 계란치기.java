import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    // 계란 클래스
    static class Egg {
        int hp;
        int attack;

        public Egg(int hp, int attack) {
            this.hp = hp;
            this.attack = attack;
        }
    }

    static Egg[] eggs;
    static int N, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        combination(0, 0);

        System.out.println(result);
    }

    private static void combination(int depth, int count) {
        if (depth == N) {
            if (result < count) {
                result = count;
            }
            return;
        }

        if (eggs[depth].hp <= 0 || count == N - 1) {
            combination(depth + 1, count);
            return;
        }

        int originHp = eggs[depth].hp;
        for (int i = 0; i < N; i++) {
            if (eggs[i].hp <= 0 || i == depth) continue;
            int vsEggHp = eggs[i].hp;
            eggs[depth].hp -= eggs[i].attack;
            eggs[i].hp -= eggs[depth].attack;

            int tmpCount = 0;
            if (eggs[depth].hp <= 0) {
                tmpCount++;
            }
            if (eggs[i].hp <= 0) {
                tmpCount++;
            }
            combination(depth + 1, count + tmpCount);

            // 원본 복구
            eggs[i].hp = vsEggHp;
            eggs[depth].hp = originHp;
        }

    }
}