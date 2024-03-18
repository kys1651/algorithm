class Solution {
    static String result = "impossible";
    static char[] alpha = {'d','l','r','u'};
    static int[] dirX ={1,0,0,-1};
    static int[] dirY ={0,-1,1,0};
    static int N,M,K,R,C;
    static boolean exit;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n; M = m;
        R = r; C = c;
        K = k;
        
        int d = getDistance(x,y,r,c);
        if((k - d) % 2 == 1 || d > k){
            return "impossible";
        }
        
        solve(x,y,0,"");
        
        return exit ? result : "impossible";
    }
   
    private static void solve(int x, int y, int count, String command){
        if(exit) return;
        
        int d = getDistance(x,y,R,C);
        if(K < d + count){
            return;
        }
        
        if(count == K){
//             if(x == R && y == C){
                
//             }
            result = command;
            exit = true;    
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if(isIn(nX,nY)){
                solve(nX,nY,count+1,command + alpha[i]);
            }
        }
    }
    
    static private boolean isIn(int x, int y){
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }
    
    static private int getDistance(int x1,int y1, int x2, int y2){
        return (int)Math.abs(x1-x2) + (int)Math.abs(y1-y2);
    }
}  