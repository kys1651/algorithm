class Solution {
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < sizes.length; i++){
            
            // 큰 값을 한 군데에 몰아넣기
            if(sizes[i][1] > sizes[i][0]){
                int tmp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = tmp;
            }
            
            if(maxX < sizes[i][0]){
                maxX = sizes[i][0];
            }
            if(maxY < sizes[i][1]){
                maxY = sizes[i][1];
            }
            
        }
        return maxX * maxY;
    }
}