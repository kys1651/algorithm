class Solution {
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        String[] morseList = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        
        String[] morse = letter.split(" ");
        
        for(String s:morse){
            for(int i = 0 ; i < morseList.length;i++){
                if(s.equals(morseList[i]))
                    sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }
}