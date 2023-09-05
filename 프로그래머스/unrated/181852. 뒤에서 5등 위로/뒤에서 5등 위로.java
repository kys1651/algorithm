import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        int [] arr = new int [num_list.length -5];
        
        System.arraycopy(num_list,5,arr,0,arr.length);
        
        return arr;
    }
}