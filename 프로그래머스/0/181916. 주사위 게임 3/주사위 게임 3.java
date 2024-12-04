import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] dice = { a, b, c, d };
        Arrays.sort(dice);
        int ret = 0;
        
        if(dice[0] == dice[3]){
            ret = 1111 * dice[0];
        }else if(dice[0] == dice[2] || dice[1] == dice[3]){
            ret = (int) Math.pow(10 * dice[1] + (dice[0] + dice[3] - dice[1]), 2);
        }else if(dice[0] == dice[1] && dice[2] == dice[3]){
            ret = (dice[0] + dice[3]) * (dice[3] - dice[0]);
        }else if(dice[0] == dice[1]){
            ret = dice[2] * dice[3];
        }else if(dice[1] == dice[2]){
            ret = dice[0] * dice[3];
        }else if(dice[2] == dice[3]){
            ret = dice[0] * dice[1];
        }else{
            ret = dice[0];
        }
        return ret;
    }
}