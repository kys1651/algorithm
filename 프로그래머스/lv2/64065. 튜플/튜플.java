import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        
        String[] arr = s.replaceAll("[{]"," ").replaceAll("[}]"," ").
            trim().split(" , ");
        // 문자열 길이 순서로 정렬
        Arrays.sort(arr,(o1,o2)-> o1.length() - o2.length());
        
        // arr 배열의 길이만큼 크기 생성
        int[] answer = new int[arr.length];
        int idx = 0;
        
        for(String s1 : arr){
            for(String s2 : s1.split(",")){
                if(set.add(s2)){
                    answer[idx++] = Integer.valueOf(s2);
                }
            }
        }
        
        return answer;
    }
}