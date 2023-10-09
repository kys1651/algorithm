import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String> list = new ArrayList<>();
        
        // list 괄호들을 제거하여 길이순으로 정렬해줌
        for(String str : s.split("},")){
            list.add(str.replaceAll("[{}]",""));
        }
        Collections.sort(list,(o1 ,o2) -> o1.length() - o2.length());
        
        // 가장 긴 길이의 숫자 크기만큼 배열 생성
        int n = list.get(list.size()-1).split(",").length;
        int[] answer = new int[n];
        
        // 기존 배열에 없던 값을 배열에 순서대로 추가 시켜준다.
        int idx = 0;
        Set<Integer> set = new HashSet<>();
        for(String str : list){
            for(String tmp : str.split(",")){
                int value = Integer.valueOf(tmp);
                
                if(!set.contains(value)){
                    set.add(value);
                    answer[idx++] = value;
                }
            }
        }
        
        return answer;
    }
}