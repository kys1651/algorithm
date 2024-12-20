class Solution {
    private static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean exit = true;
        
        for(String word : words){
            if(word.equals(target)){
                exit = false;
                break;
            }
        }
        
        if(!exit) solve(words, new boolean[words.length], 0, begin, target);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    private static void solve(String[] words, boolean[] visit, int count, String now, String target){
        if(answer != 0 && answer < count) return;

        if(now.equals(target)){
            answer = Math.min(count, answer);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(!visit[i] && isValid(now, words[i])){
                visit[i] = true;
                solve(words, visit, count + 1, words[i], target);
                visit[i] = false;
            }
        }
    }
    
    private static boolean isValid(String a, String b){
        int count = a.length();
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == b.charAt(i)){
                count--;
            }
        }
        return count == 1;
    }
}