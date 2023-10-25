import java.util.*;

class Solution {
    static char[] numArr;
    static boolean[] visit;
    static Set<Integer> set;
    public int solution(String numbers) {
        int count = 0;
        numArr = numbers.toCharArray();
        visit = new boolean[numbers.length()];
        set = new HashSet<>();
        tracking(0,"");
        for(int num : set){
            if(isPrime(num)){
                count++;
            }
        }
        return count;
    }
    private void tracking(int depth,String sum){
        if(depth == numArr.length){
            if(!sum.equals("")){
                set.add(Integer.valueOf(sum));
            }
            return;
        }
        
        // 연산
        for(int i = 0; i < numArr.length; i++){
            if(!visit[i]){
                visit[i] = true;    
                tracking(depth+1, sum + numArr[i]);
                tracking(depth+1,sum);
                visit[i] = false;
            }
        }
        
        
    }
    
    private boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}