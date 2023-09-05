import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        return Arrays.stream(arr).filter(i -> !include(delete_list,i)).toArray();
    }
    
    public boolean include(int[] arr, int num){
        for(int a : arr){
            if(a == num) return true;
        }
        return false;
    }
}