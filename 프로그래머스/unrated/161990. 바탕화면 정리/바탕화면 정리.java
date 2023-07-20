class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {51,51,-1,-1};
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                char ch = wallpaper[i].charAt(j);
                if(ch == '#'){
                    if(answer[0] > i){
                        answer[0] = i;
                    }
                    if(answer[1] > j){
                        answer[1] = j;
                    }
                    if(answer[2] < i){
                        answer[2] = i;
                    }
                    if(answer[3] < j){
                        answer[3] = j;
                    }
                }
            }
        }
        answer[2]++; answer[3]++;
        return answer;
    }
}