class Solution {
    public int solution(int[][] sizes) {
        int length = 0;
        int height = 0;
        
        for(int[] num:sizes){
            length = Math.max(length,Math.max(num[0],num[1]));
            height = Math.max(height,Math.min(num[0],num[1]));
        }
        return length * height;
    }
}