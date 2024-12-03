class Solution {
    public int solution(int[][] board) {
        int[] dirX = {-1, 1, 0, 0,-1,-1, 1, 1};
        int[] dirY = { 0, 0,-1, 1,-1, 1, 1,-1};
        
        int answer = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 0){
                    boolean flag = true;
                    for(int k = 0; k < dirX.length; k++){
                        int nX = i + dirX[k];
                        int nY = j + dirY[k];
                        if(nX >= 0 && nX < board.length && nY >= 0 && nY < board[0].length && board[nX][nY] == 1){
                            flag = false;
                        }
                    }
                    if(flag) answer++;
                }
            }
        }
        return answer;
    }
}