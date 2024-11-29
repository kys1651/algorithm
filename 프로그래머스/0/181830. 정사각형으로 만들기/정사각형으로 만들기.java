class Solution {
    public int[][] solution(int[][] arr) {
        return getAnswer(arr, arr.length, arr[0].length);
    }
    
    private static int[][] getAnswer(int[][] arr, int rowSize, int colSize){
        int size = Math.max(rowSize, colSize);
        int[][] answer = new int[size][size];
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }
}