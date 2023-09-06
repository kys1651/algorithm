import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        String A = "";
        String B = "";
        for(int n : num_list){
            if(n % 2 ==0){
                A += n;
            }else{
                B += n;
            }
        }
        return Integer.parseInt(A) + Integer.parseInt(B);
    }
}