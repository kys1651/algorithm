import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Main {
    static int[] ladders;
    static int[] snake;
    static int[] counts;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ladders = new int[101];
        snake = new int[101];
        counts = new int[101];
        for(int i = 0; i < n ; i++){
            ladders[sc.nextInt()] = sc.nextInt();
        }
        for(int i = 0; i < m ; i++){
            snake[sc.nextInt()] = sc.nextInt();
        }
        bfs(1, snake, ladders, counts);
        System.out.println(counts[100]);
	}

    private static void bfs(int start, int[] snake,int[] ladders, int [] counts) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i = 1; i <=6; i++){
                int next = cur + i;
                if(next > 100){
                    continue;
                }
                if(counts[next] != 0 &&counts[next] <= counts[cur] + 1){
                    continue;
                }
                // 일단 거기 가는 경우의 수가 제일 
                counts[next] = counts[cur] + 1;
                if(ladders[next] != 0){
                    if(counts[ladders[next]] == 0 || counts[ladders[next]] > counts[next]){
                        counts[ladders[next]] = counts[next];
                        queue.offer(ladders[next]);
                    }
                    // 연산
                }else if(snake[next] != 0){
                    if(counts[snake[next]] == 0 || counts[snake[next]] > counts[next]){
                        counts[snake[next]] = counts[next];
                        queue.offer(snake[next]);
                    }
                }else{
                    queue.offer(next);
                }
            }
        }
    }
}