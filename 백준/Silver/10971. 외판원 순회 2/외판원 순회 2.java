import java.util.Scanner;

class Main
{
    static int map[][]; // n x n값이 저장된 배열
    static int n;
    static boolean[] visit;
    static int minCost = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        visit = new boolean[n];
        map = new int[n][n];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0; i < n; i++){
            visit[i] = true;
            go(i,i,0,0);
        }

        System.out.println(minCost);
    }

    private static void go(int start, int now, int depth, int sum) {
        if(depth == n - 1){
            // 마지막 위치에서 출발 지점까지 0이 아니라면(갈 수 있음)
            if(map[now][start] != 0){
                sum += map[now][start];
                minCost = Math.min(sum, minCost);
            }
            return;
        }

        for(int i = 0; i < n; i++){
            // i 도시로 간 적 있거나 가는 비용이 0이라면 갈 이유가 없음
            if(visit[i] || map[now][i] == 0){
                continue;
            }

            visit[i] = true;
            // start는 계속 유지, now는 i로 초기화
            go(start, i, depth + 1, sum + map[now][i]);
            visit[i] = false;
        }
        
    }
}