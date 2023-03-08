class Solution {
    public int[] solution(int[] array) {
        int index = 0;
        
        for(int i=0; i<array.length;i++){
            if(array[i]>array[index]){
                index = i;
            }
        }
        int[] answer = {array[index], index};
        return answer;
    }
}