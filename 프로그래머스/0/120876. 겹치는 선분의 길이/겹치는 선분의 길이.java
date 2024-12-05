import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int[] lineCheck = new int[201];
        for(int[] line : lines){
            int start = line[0] + 100;
            int end = line[1] + 100;
            for(int i = start; i < end; i++){
                lineCheck[i] += 1;
            }
        }
        
        int answer = 0;
        for(int i = 0; i < lineCheck.length; i++){
            if(lineCheck[i] > 1) answer++;
        }
        return answer;
    }
}