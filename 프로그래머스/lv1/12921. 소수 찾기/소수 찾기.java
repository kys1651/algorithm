class Solution {
    static boolean[] checked;
    public int solution(int n) {
        int answer = 0;
        checked = new boolean[n+1];
        checked[0] = checked[1] = true;
        
        Prime(n);
        
        for(boolean c : checked){
            if(!c){
                answer++;
            }
        }
        return answer;
    }
    
    // 에라토스테네스의 체
    private void Prime(int n){
        for(int i = 2; i <= n ; i++){
            if(!checked[i]){
                for(int j = i+i; j <= n; j+= i){
                    checked[j] = true;
                }
            }
        }
    }
}