class Solution {
    static String[] dic = {"A","E","I","O","U"};
    static int result = 0;
    static int count = -1;
    public int solution(String word) {
        brute(0,"",word);
        return result;
    }
    
    private static void brute(int depth,String word,String goal){
        count++;
        if(word.equals(goal)){
            result = count;
            return;
        }
        if(result != 0 || depth == 5){return;}
        for(int i = 0; i < dic.length; i++){
            brute(depth+1,word + dic[i],goal);
        }
    }
}