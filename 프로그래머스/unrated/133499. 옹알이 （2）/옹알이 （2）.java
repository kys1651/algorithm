class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] check = {"aya","ye","woo","ma"};
        
        for(int i = 0; i < babbling.length; i++){
            String b = babbling[i];
            
            b = b.replaceAll("ayaaya|yeye|woowoo|mama"," ");
            b = b.replaceAll("aya|ye|woo|ma","");
            
            if(b.equals(""))
                answer++;
        }
        
        return answer;
    }
}