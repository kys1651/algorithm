class Solution {
    static char[] commands = {'U', 'D', 'R', 'L'};
    static int[] dirX = {1,-1,0,0};
    static int[] dirY = {0,0,1,-1};
    static boolean[][][] map = new boolean[11][11][4];
    
    public int solution(String dirs) {
        int curX = 5, curY = 5, count = 0;
        for(char dir : dirs.toCharArray()){
            int d = getCommand(dir);
            int nX = curX + dirX[d];
            int nY = curY + dirY[d];
            if(!isIn(nX,nY)){
                continue;
            }
            int rD = reverseDir(d);
            if(!map[curX][curY][d] && !map[nX][nY][rD]){
                count++;
                map[curX][curY][d] = map[nX][nY][rD] = true;
            }
            curX = nX;
            curY = nY;
        }
        
        return count;
    }
    
    private static boolean isIn(int x,int y){
        return x >= 0 && x <= 10 && y >= 0 && y <= 10;
    }
    
    private static int reverseDir(int dir){
        if(dir == 0) return 1;
        else if(dir == 1) return 0;
        else if(dir == 2) return 3;
        else return 2;
    }
    
    private static int getCommand(char command){
        for(int i = 0; i < 4; i++){
            if(command == commands[i]){
                return i;
            }
        }
        return -1;
    }
}