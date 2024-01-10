import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Solution{
	static boolean[][] map;
    static boolean[] visit;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;	
		for(int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            visit = new boolean[101];
            map = new boolean[101][101];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = true;
            }
           
            int result = bfs(start);
            sb.append("#" + tc + " " + result).append("\n");
		}
        System.out.println(sb);
	}
    private static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;
        int result = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            result = 0;
            for(int l= 0; l < len; l++){
                int current = queue.poll();
                result = Math.max(result,current);
                for(int i = 1; i <= 100; i++){
                	if(!map[current][i] || visit[i]) continue;
                
                	visit[i] = true;
                	queue.offer(i);
                }
            }
        }
        return result;
    }
}