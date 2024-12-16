class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int a = arr1.length;
        int b = arr1[0].length;
        int c = arr2.length;
        int d = arr2[0].length;
        
        int[][] answer = new int[a][d];
        for(int i = 0; i < a; i++){
            for(int j = 0; j < d; j++){
                int sum = 0;
                for(int k = 0; k < c; k++){
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}