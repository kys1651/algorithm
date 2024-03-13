class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visit[i]) continue;
            answer++;
            dfs(i,n,computers);
        }
        return answer;
    }
    
    private static void dfs(int cur, int size, int[][] graph){
        visit[cur] = true;
        for(int i = 0 ; i < size; i++){
            if(!visit[i] && graph[cur][i] == 1){
                dfs(i,size,graph);
            }
        }
    }
}