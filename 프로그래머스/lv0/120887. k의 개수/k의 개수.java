class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(; i <= j ; i++){
            char[] arr = String.valueOf(i).toCharArray();
            for(char ch:arr){
                if(ch==('0'+k)){
                    answer++;
                }
            }
        }
        return answer;
    }
}