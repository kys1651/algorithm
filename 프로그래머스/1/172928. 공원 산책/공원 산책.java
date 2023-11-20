class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] map = new char[park.length][park[0].length()];
        int robotX = 0;
        int robotY = 0;
        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S'){
                    robotX = i;
                    robotY = j;
                }
            }
        }
        for(int i = 0; i < routes.length; i++){
            String[] command = routes[i].split(" ");
            int move = Integer.valueOf(command[1]);
            int d = 0;
            switch(command[0]){
                case "N":
                    d = 0;
                    break;
                case "S":
                    d = 1;
                    break;
                case "W":
                    d = 2;
                    break;
                case "E":
                    d = 3;
                    break;
            }
            int nx = robotX;
            int ny = robotY;
            boolean canMove = true;
            for(int j = 0; j < move; j++){
                nx += dirX[d];
                ny += dirY[d];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length || map[nx][ny] =='X'){
                    canMove = false;
                    break;
                }
            }
            if(canMove){
                robotX = nx;
                robotY = ny;
            }
        }
        return new int[] {robotX,robotY};
    }
}