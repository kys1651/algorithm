class Solution {
    public String solution(String myString, String pat) {
        for(int i = myString.length(); i >= 0; i--){
            String tmp = myString.substring(0,i);
            if(tmp.endsWith(pat)) return tmp;
        }
        return "";
    }
}