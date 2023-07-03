class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int a = 0;
        int b = 0;
        for(int i = 0; i < goal.length; i++){
            if(a < cards1.length && goal[i].equals(cards1[a])){
                a++;
                continue;
            }
            if(b < cards2.length && goal[i].equals(cards2[b])){
                b++;
                continue;
            }
            
            return "No";
        }
        return "Yes";
    }
}