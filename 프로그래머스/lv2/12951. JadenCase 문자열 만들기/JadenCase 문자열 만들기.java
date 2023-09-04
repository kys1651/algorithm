class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean flag = true;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isAlphabetic(ch)){
                if(flag == true){
                    ch = Character.toUpperCase(ch);
                    flag = false;
                }else{
                    ch = Character.toLowerCase(ch);
                }
            }else if(ch == ' '){
                flag = true;
            }else{
                flag = false;
            }
            
            sb.append(ch);
        }
        return sb.toString();
    }
}