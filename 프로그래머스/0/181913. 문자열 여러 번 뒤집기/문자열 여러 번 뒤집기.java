class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] answer = my_string.toCharArray();
        for(int[] pos : queries){
            reverse(answer, pos[0], pos[1]);
        }
        return new String(answer);
    }
    
    private static void reverse(char[] answer, int s, int e){
        while(s < e){
            char tmp = answer[s];
            answer[s++] = answer[e];
            answer[e--] = tmp;
        }
    }
}