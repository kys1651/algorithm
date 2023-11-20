class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder front = new StringBuilder(my_string.substring(0,s));
        StringBuilder mid = new StringBuilder(my_string.substring(s,e+1));
        StringBuilder back = new StringBuilder(my_string.substring(e+1));
        return front.append(mid.reverse()).append(back).toString();
    }
}