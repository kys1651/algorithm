class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        String[] commands = {"w","s","d","a"};
        int num = 0;
        for(int i = 1; i < numLog.length; i++){
            int value = numLog[i] - numLog[i-1];
            
            switch(value){
                case 1:
                    num = 0;
                    break;
                case -1:
                    num = 1;
                    break;
                case 10:
                    num = 2;
                    break;
                case -10:
                    num = 3;
                    break;
            }
            answer.append(commands[num]);
        }
        
        return answer.toString();
    }
}