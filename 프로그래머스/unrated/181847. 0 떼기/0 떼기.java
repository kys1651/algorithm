class Solution {
    public String solution(String n_str) {
        int idx = 0;
        while(true){
            if(n_str.charAt(idx)!='0')
                break;
            idx++;
        }
        return n_str.substring(idx);
    }
}