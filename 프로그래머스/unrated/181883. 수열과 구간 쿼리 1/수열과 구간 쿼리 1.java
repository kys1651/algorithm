class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int[] query : queries){
            int idx = query[0];
            int end = query[1];
            
            for(;idx <= end; idx++){
                arr[idx]++;
            }
        }
        return arr;
    }
}