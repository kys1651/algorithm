class Solution {
    public String solution(int a, int b) {
        String[] answer = {"THU","FRI","SAT","SUN","MON","TUE","WED",};
        int mon = 0;
        
        for(int i = 1; i < a; i++){
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10){
                mon += 31;
            }else if(i == 2){
                mon += 29;
            }else{
                mon += 30;
            }
        }
        mon += b;
        
        int days = mon % 7;
        return answer[days];
    }
}