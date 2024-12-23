class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        int[][] map = new int[m + 1][n + 1];
        map[1][1] = 1;
        
        for(int[] puddle : puddles) map[puddle[0]][puddle[1]] = -1;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == -1 || (i == 1 && j == 1)) continue;
                map[i][j] = (Math.max(0,map[i-1][j]) + Math.max(0,map[i][j-1])) % MOD;
            }
        }
        return map[m][n];
    }
}