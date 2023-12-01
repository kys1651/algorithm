import java.util.HashMap;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String str : strArr){
            int len = str.length();
            map.put(len, map.getOrDefault(len,0)+1);
            answer = Math.max(answer, map.get(len));
        }
        return answer;
    }
}