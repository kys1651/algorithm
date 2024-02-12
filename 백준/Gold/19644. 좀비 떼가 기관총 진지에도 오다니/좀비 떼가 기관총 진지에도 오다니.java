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
//                System.out.println("감소" + killZombie.peek());
                damage -= killZombie.poll();
            }

            damage += K;
//            System.out.println(hp + " " + damage);
            // 현재 데미지로 죽일 수 있는 경우
            if (hp <= damage) {
                killZombie.add(K);
            }
            // 못죽이는 경우
            else{
                if(C > 0){
                    killZombie.add(0);
                    C--;
                    damage -= K;
                }else{
                    result = "NO";
                    break;
                }
            }
        }

        System.out.println(result);
    }
}