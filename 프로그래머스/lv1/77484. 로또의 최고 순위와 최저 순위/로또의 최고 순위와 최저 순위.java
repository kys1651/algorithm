class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int matchCnt = 0;
        int zeroCnt = 0;
        
        for(int l : lottos){
            if(l == 0){
                zeroCnt++;
                continue;
            }
            
            for(int w : win_nums){
                if(l == w){
                    matchCnt++;
                }
            }
        }
        
        
        int [] answer = new int[2];
        answer[0] = Math.min(7 - (zeroCnt + matchCnt),6);
        answer[1] = Math.min(7 - matchCnt, 6);
        
        return answer;
    }
}