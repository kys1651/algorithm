class Solution {
    public int solution(String my_string) {
        my_string += "_";
        int answer = 0;
        String num = "0";
        my_string = my_string.replaceAll("[^0-9]","_");
        
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i)=='_') {
                answer += Integer.parseInt(num);
                num = "0";
                continue;
            }
            num += my_string.charAt(i)-'0';
        }
        
        return answer;
    }
}