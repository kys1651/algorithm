class Solution {
    public String solution(String my_string, int n) {
        StringBuffer sb = new StringBuffer();
        String[] arr = my_string.split("");

        for(String c : arr){
            for(int i = 0 ; i < n; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}