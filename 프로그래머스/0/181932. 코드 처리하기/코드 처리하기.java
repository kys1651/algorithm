class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        char[] codeArr = code.toCharArray();
        
        int mode = 0;
        for(int i = 0; i < codeArr.length; i++){
            if(Character.isDigit(codeArr[i])){
                mode = (mode + 1) % 2;
            } else if(i % 2 == mode){
                answer.append(codeArr[i]);
            }
        }
        String ret = answer.toString();
        return ret.length() == 0 ? "EMPTY" : ret;
    }
}