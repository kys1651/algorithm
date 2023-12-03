import java.util.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        // 입력값 〉 2, [0, 1, 1], [10, 8, 6, 4, 2]
        // 기댓값 〉 [10, 8, 6, 4, 2]


        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        int plus = 1;
        if(n == 1){
            end = slicer[1];
        } else if(n == 2){
            start = slicer[0];
            end = num_list.length - 1;
        } else if(n == 3){
            start = slicer[0];
            end = slicer[1];
        } else {
            start = slicer[0];
            end = slicer[1];
            plus = slicer[2];
        }
        for(; start <= end; start += plus){
            list.add(num_list[start]);
        }
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}