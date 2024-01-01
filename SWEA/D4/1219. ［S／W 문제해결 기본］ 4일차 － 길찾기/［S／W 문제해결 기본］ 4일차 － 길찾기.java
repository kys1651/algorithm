import java.util.StringTokenizer;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static int[][] graph;
    static boolean[] visit;
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            
            graph = new int[100][2];
            visit = new boolean[100];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n; i++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                if(graph[start][0] == 0){
                    graph[start][0] = end;
                }else{
                    graph[start][1] = end;
                }
            }
            
            sb.append("#" + tc + " " + (checkPath() ? "1" : "0")).append("\n");
		}
        System.out.println(sb);
	}
    private static boolean checkPath(){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(cur == 99) return true;
            if(graph[cur][0] != 0){
                stack.push(graph[cur][0]);
            }
            if(graph[cur][1] != 0){
                stack.push(graph[cur][1]);
            }
        }
        return false;
    }
}