import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        Queue<Integer> killZombie = new LinkedList<>();

        String result = "YES";
        int damage = 0;
        for (int i = 1; i <= N; i++) {
            int hp = Integer.parseInt(br.readLine());

            if(killZombie.size() == L){
                damage -= killZombie.poll();
            }

            // 현재 데미지로 죽일 수 있는 경우
            if (hp <= damage + K) {
                killZombie.add(K);
                damage += K;
            }
            // 못죽이는 경우
            else{
                if(C > 0){
                    killZombie.add(0);
                    C--;
                }else{
                    result = "NO";
                    break;
                }
            }
        }

        System.out.println(result);
    }
}