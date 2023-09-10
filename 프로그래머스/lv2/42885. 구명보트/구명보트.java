import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        for(; left < right;right--){
            if(people[left] + people[right] <= limit){
                left++;
            }
        }
        
        return people.length - left;
    }
}