import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n,1, 3, 2);
        /*
            N = 1일 때 목표지점으로 바로 옮김 - 1번
            N = 2일 때 - 1번 + (N - 1) * 2 - 3번
                1) N - 1(1번)을 중간지점으로 옮긴다.
                2) N을 목표지점으로 옮김.(1번)
                3) N - 1(1번)을 다시 목표지점으로 옮긴다.
            N = 3일 때 - 1번 + (N - 1) * 2 - 7번
                1) N - 2(3번)를 중간 지점으로 옮긴다.
                2) N을 목표지점으로 옮긴다.(1번)
                3) N - 2번(3번)을 다시 목표으로 옮긴다.
            즉, 등비가 2고 초항이 r인 등비수열의 합 공식 : 2^n - 1
         */
        System.out.println((int) (Math.pow(2, n) - 1));
        System.out.println(sb);
    }

    // N개의 원판을 cur(현재 지점)에서 goal(목표 지점)로 옮기기
    private static void hanoi(int n,int cur, int goal, int middle) {
        // n이 1이면 가장 작은 원판으로 자유롭게 이동이 가능함
        if(n == 1){
            sb.append(cur + " " + goal + "\n");
            return;
        }

        // n을 목표지점으로 옮기기 위해서는 n-1(즉, n위에 있는 원판들)개의 원판을 middle로 옮겨야 한다.
        hanoi(n - 1, cur, middle, goal);
        // n-1개를 middle(현재 지점과 목표지점이 아닌 다른 곳)으로 옮겼다면 현재 원판을 goal로 옮길 수 있음
        sb.append(cur + " " + goal + "\n");
        // n개 원판들을 중간지점(목표지점과 현재지점이 아닌 곳)에서 목표지점으로 다시 옮겨줘야한다.
        hanoi(n - 1, middle, goal, cur);
    }
}
