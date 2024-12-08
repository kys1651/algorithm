class Solution {
    public int solution(int[][] dots) {
        if(gradient(dots[0], dots[1]) == gradient(dots[2],dots[3]) ||
            gradient(dots[0],dots[2]) == gradient(dots[1],dots[3]) || 
            gradient(dots[0], dots[3]) == gradient(dots[1], dots[2])
          ){
            return 1;
        }
        return 0;
    }
    
    public double gradient(int[] dot1, int[] dot2) {
        return (dot2[1] - dot1[1]) * 1.0 / (dot2[0] - dot1[0]);
    }
}