class Solution {
    public int solution(String s) {
        int result = 0;
        boolean Sign = true;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '-') Sign = false;
            else if(ch != '+')
                result = result * 10 + (ch -'0');
        }
        return (Sign?1:-1) * result;
    }
}