import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while(left <= right){
            int leftPeople = people[left];
            int rightPeople = people[right];
            
            answer++;
            if(left == right){
                break;
            }
            else if(leftPeople + rightPeople <= limit){
                left++;
                right--;
                continue;
            }else{
                right--;
            }
        }
        return answer;
    }
}