class Solution {
    public String solution(String s) {
        String answer = "";
        String[] array = s.split("");
        int count = 0;
        
        for(int i = 0 ; i < array.length; i++){
            if(array[i].equals(" ")) {
                count = 0;
            }else if(count % 2 ==0){
                array[i] = array[i].toUpperCase();
                count++;
            }else if(count % 2 != 0){
                array[i] = array[i].toLowerCase();
                count++;
            }
            answer += array[i];
            }
        return answer;
    }
}