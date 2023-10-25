class Solution {
    static int answer = -1;
    static boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        track(k,0,0,dungeons);
        return answer;
    }
    
    private void track(int curK,int depth, int count,int[][] dungeons){
        if(depth == dungeons.length){
            answer = Math.max(count,answer);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            if(curK >= dungeons[i][0]){
                track(curK - dungeons[i][1],depth + 1, count+1,dungeons);
            }
            track(curK,depth+1,count,dungeons);
            visit[i] = false;
        }
    }
}