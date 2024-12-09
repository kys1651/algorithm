import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 단어를 저장할 HashMap 생성
        HashMap<String, Integer> idx2idx = new HashMap<>();
        int size = 27;
        
        // msg를 char로 바꾸고 확인한다.
        ArrayList<Integer> answer = new ArrayList<>();
        char[] msgCharArr = msg.toCharArray();
        for(int i = 0; i < msgCharArr.length; i++){
            int j = i + 1;
            int wordNum = msgCharArr[i] - 'A' + 1;
            StringBuilder checkWord = new StringBuilder();
            checkWord.append(msgCharArr[i]);
            while(j != msgCharArr.length){
                checkWord.append(msgCharArr[j]);
                if(idx2idx.containsKey(checkWord.toString())){
                    j++;
                    i++;
                    wordNum = idx2idx.get(checkWord.toString());
                } else{
                    break;
                }
            }
            idx2idx.put(checkWord.toString(), size++);
            answer.add(wordNum);
        }
        
        int[] ret = new int[answer.size()];
        for(int i = 0; i < ret.length; i++){
            ret[i] = answer.get(i);
        }
        return ret;
    }
    
    private static HashMap<String, Integer> getIdx2Idx(){
        HashMap<String, Integer> idx2idx = new HashMap<>();
        for(int i = 0; i < 26; i++){
            idx2idx.put("" + ('A' + i), 1 + i);
        }
        return idx2idx;
    }
}