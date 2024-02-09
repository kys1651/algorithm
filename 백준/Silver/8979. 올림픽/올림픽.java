import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: Main_1260_DFS와BFS
 *
 * @author 김용수
 * 제출한 시간: 2024년 2월 9일 16:25:56
 * 메모리: 17180KB
 * 시간: 184ms
 * <p>
 * 접근 방법:
 * 1. 인접리스트를 이용하여 표현한다.
 * 2. 양방향 리스트를 적은 순으로 방문해야하기 때문에 입력을 받고 난 후 정렬 시켜준다.
 * 3. 속도를 줄이기 위해서 StringBuilder 사용
 */
public class Main {
    static class Nation implements Comparable<Nation> {
        int idx;
        int gold;
        int silver;
        int bronze;

        public Nation(int idx, int gold, int silver, int bronze) {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation n) {
            if (gold != n.gold) {
                return n.gold - gold;
            }
            if (silver != n.silver) {
                return n.silver - silver;
            }
            if (bronze != n.bronze) {
                return n.bronze - bronze;
            }

            return 0;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Nation[] nations = new Nation[N];
        Nation target = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            nations[i] = new Nation(idx, gold, silver, bronze);
            if (idx == K) target = nations[i];
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (target.compareTo(nations[i]) > 0) {
                count++;
            }
        }
        System.out.println(count + 1);
    }
}