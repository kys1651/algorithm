import java.util.Scanner;

class Main
{
    static int map[][]; // n x n값이 저장된 배열
    static int n;
    static int[] route;
    static boolean[] visit;
    static int minCost = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        route = new int[n];
        visit = new boolean[n];
        map = new int[n][n];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        go(0);

        System.out.println(minCost);
    }

    private static void go(int depth) {
        if(depth == n){
            // cost 값 구하기
            int cost = 0;
            int tmpCost = 0;
            for(int i = 0; i < n; i++){
                if(i == n-1){
                    tmpCost = map[route[n-1]][route[0]];
                }else{
                    tmpCost = map[route[i]][route[i+1]];
                }
                
                if(cost > minCost || tmpCost == 0){
                    return;
                }
                cost += tmpCost ;
            }
            minCost = Math.min(minCost, cost);
            
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(visit[i]){
                continue;
            }
            route[depth] = i;
            visit[i] = true;
            go(depth+1);
            visit[i] = false;
        }
    }
}