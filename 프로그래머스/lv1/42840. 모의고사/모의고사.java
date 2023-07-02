import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] mathA = {1,2,3,4,5};
        int[] mathB = {2,1,2,3,2,4,2,5};
        int[] mathC = {3,3,1,1,2,2,4,4,5,5};
        
        int[] answer = new int[3];
        for(int i = 0 ; i < answers.length; i++){
            if(mathA[i % mathA.length] == answers[i]) answer[0]++;
            if(mathB[i % mathB.length] == answers[i]) answer[1]++;
            if(mathC[i % mathC.length] == answers[i]) answer[2]++;
        }
        
        int max = answer[0];
        int count = 0;
        for(int i = 0; i < 3; i++){
            if(max < answer[i]){
                max = answer[i];
                count = 1;
            }else if(max == answer[i]){
                count ++;
            }
        }
        
        int [] scores = new int[count];
        
        for(int i = 0,idx = 0; i < 3; i++){
            if(max == answer[i]){
                scores[idx++] = i+1;
            }
        }
        
        
        return scores;
    }
}