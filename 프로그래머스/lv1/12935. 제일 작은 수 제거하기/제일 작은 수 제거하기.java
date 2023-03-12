import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int num:arr) 
            answer.add(num);
        Arrays.sort(arr);
        answer.remove(answer.indexOf(arr[0]));
        if(arr.length==1) return new int[]{-1};
        return answer.stream().mapToInt(i->i).toArray();
    }

}