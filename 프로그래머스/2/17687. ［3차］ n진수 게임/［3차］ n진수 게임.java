class Solution {
    public String solution(int n, int t, int m, int p) {
        int start = 0;
        StringBuilder totalString = new StringBuilder();
        while(totalString.toString().length() < m * t){
            totalString.append(Integer.toString(start++, n));
        }
        
        StringBuilder answer = new StringBuilder();
        String total = totalString.toString();
        for(int i = 0; i < t; i++){
            answer.append(total.charAt(p - 1 + i * m));
        }
        
        return answer.toString().toUpperCase();
    }
}