import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        long curAttack = Integer.parseInt(st.nextToken());
        long curHp = 0, max = 0;

        long t, a, h;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 몬스터 방인 경우
            if (t == 1) {
                // 용수가 공격 받는 횟수
                long count = h / curAttack;
                if (h % curAttack == 0) count--; // 0으로 나우어 떨어진 경우 ( 용사가 공격해서 끝난 경우 )
                curHp += count * a; // 현재 체력에 받는 데미지를 더 해준다.
                max = Math.max(curHp, max); // 가장 많이 받는 데미지를 기록
            } else {
                curAttack += a; // 공격력 증가
                curHp = Math.max(curHp - h, 0); // 0보다 작아지는 경우( 최대 체력 이상으로 체력을 회복한 경우 )
            }
        }
        System.out.println(max + 1);

    }
}