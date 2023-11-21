class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            swap(queries[i][0],queries[i][1],arr);
        }
        return arr;
    }
    private static void swap(int x, int y, int[] arr){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}