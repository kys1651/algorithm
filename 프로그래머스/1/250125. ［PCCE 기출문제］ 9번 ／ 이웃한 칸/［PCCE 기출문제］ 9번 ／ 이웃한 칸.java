class Solution {
    public int solution(String[][] board, int h, int w) {
        int len = board.length, count = 0;
        
        int[] dirX = {1, -1,  0, 0};
        int[] dirY = {0,  0, -1, 1};
        String origin = board[h][w];
        for(int i = 0; i < 4; i++){
            int nX = h + dirX[i];
            int nY = w + dirY[i];
            if(isValid(nX,nY, len) && origin.equals(board[nX][nY])){
                count++;
            }
        }
        
        return count;
    }
    
    private static boolean isValid(int x, int y, int n){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}