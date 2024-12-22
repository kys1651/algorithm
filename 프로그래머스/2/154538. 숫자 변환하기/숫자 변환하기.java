import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return solve(x, y, n, new boolean[y + 1]);
    }
    
    private static int solve(int start, int target, int n, boolean[] check){
        Queue<int[] > q = new LinkedList<>();
        q.add(new int[] {start, 0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0];
            int nextCount = cur[1] + 1;
            if(now == target) return cur[1];
            if(check[now]) {
                continue;
            } else {
                check[now] = true;
            }
            if(isIn(now + n, target) && !check[now + n]) q.add(new int[] {now + n, nextCount});
            if(isIn(now * 2, target) && !check[now * 2]) q.add(new int[] {now * 2, nextCount});
            if(isIn(now * 3, target) && !check[now * 3]) q.add(new int[] {now * 3, nextCount});
        }
        return -1;
    }
    
    private static boolean isIn(int value, int limit){
        return value <= limit;
    }
}