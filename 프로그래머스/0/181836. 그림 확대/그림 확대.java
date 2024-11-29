class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int idx = 0;
        for(String p : picture){
            StringBuilder line = new StringBuilder();
            for(char c : p.toCharArray()){
                for(int i = 0; i < k ; i++){
                    line.append(c);    
                }
            }
            for(int i = 0; i < k; i++){
                answer[idx++] = line.toString();
            }
        }
        return answer;
    }
}