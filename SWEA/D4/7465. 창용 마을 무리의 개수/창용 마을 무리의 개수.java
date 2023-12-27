import java.util.StringTokenizer;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static boolean[][] graph;
    static boolean[] visit;
    static int n;
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph = new boolean[n+1][n+1];
            visit = new boolean[n+1];
            
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = graph[b][a] = true;
            }
            
            int result = 0;
            for(int i = 1; i <= n; i++){
                if(!visit[i]){
                    result++;
                    dfs(i);
                }
            }
			sb.append("#" + tc + " " + result).append("\n");
		}
        System.out.println(sb);
	}
    private static void dfs(int start){
        Stack<Integer> stack = new Stack<>();
        visit[start] = true;
        stack.push(start);
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
            for(int i = 1; i <= n; i++){
                if(graph[cur][i] && !visit[i]){
                    stack.push(i);
                    visit[i] = true;
                }
            }
        }
    }
}