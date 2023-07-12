class Solution {
    public int solution(String s) {
        int answer = 0;
        char curCh = s.charAt(0);
        int mCount = 1;
        int sCount = 0;
        
        for(int i = 1 ; i< s.length(); i++){
            if(curCh == ' '){
                curCh = s.charAt(i);
                continue;
            }
            
            char nextCh = s.charAt(i);
            if(curCh == nextCh){
                mCount++;
            }else{
                sCount++;
            }
            
            if(mCount == sCount){
                answer++;
                mCount = 1;
                sCount = 0;
                curCh = ' ';
            }
        }
        
        if(curCh != ' '){
            answer++;
        }
        return answer;
    }
}