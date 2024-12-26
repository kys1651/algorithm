import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        HashMap<Character, Integer> word2Idx = getHashMap(skill);
        
        int answer = 0;
        for(String skillTree : skill_trees){
            if(isValid(skillTree, word2Idx)) answer++;
        }
        return answer;
    }
    
    private static boolean isValid(String skillTree, HashMap<Character, Integer> word2Idx){
        int curIdx = 0;
        for(char ch : skillTree.toCharArray()){
            if(!word2Idx.containsKey(ch)) continue;
            
            if(word2Idx.get(ch) == curIdx) curIdx++;
            else return false;
        }
        
        return true;
    }
    
    private static HashMap<Character, Integer> getHashMap(String skill) {
        HashMap<Character, Integer> word2Idx = new HashMap<>();
        for(int i = 0; i < skill.length(); i++){
            word2Idx.put(skill.charAt(i), i);
        }
        return word2Idx;
    }
}