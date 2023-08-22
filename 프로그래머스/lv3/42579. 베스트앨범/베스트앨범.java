import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르를 합산하는 HashMap
        Map<String, Integer> num = new HashMap<>();
        // 장르별로 노래를 저장하는 HashMap
        Map<String, HashMap<Integer,Integer>> music = new HashMap<>();
        // 정답을 저장하기 위한 List
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0 ; i < plays.length; i++){
            // num Map에 존재하지 않는다면 새로운 map을 생성 후 넣어준다.
            if(!num.containsKey(genres[i])){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i,plays[i]);
                music.put(genres[i],map);
                num.put(genres[i],plays[i]);
            }else{
                // 이미 존재 한다면 값을 바로 넣어줌
                music.get(genres[i]).put(i,plays[i]);
                num.put(genres[i],num.get(genres[i])+plays[i]);
            }
        }
        
        // num에 있는 key값들을 가져와서 value 내림차순으로 정렬하여줌
        List<String> keySet = new ArrayList(num.keySet());
        Collections.sort(keySet,(s1,s2) -> {
            return num.get(s2) - num.get(s1);
        });
        
        // 차례대로 가져온다.
        for(String key : keySet){
            // 내림차순으로 정렬된 장르별 map을 가져옴
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> list = new ArrayList(map.keySet());
            
            // 각 곡의 수를 내림차순으로 정렬
            Collections.sort(list,(s1,s2)->map.get(s2)-map.get(s1));
            
            // 1곡만 있을 수 있으므로 0만 넣어줌
            answer.add(list.get(0));
            // 1곡 이상이라면 AnswerList에 한곡 더 넣어준다.
            if(list.size() > 1){
                answer.add(list.get(1));
            }
        }
        
        // Stream을 이용하여 List를 배열로 변환하여 넣어줌        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}