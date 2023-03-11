class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i < quiz.length; i++){
            String[] text = quiz[i].split(" ");
            int result = Integer.parseInt(text[0])+
                Integer.parseInt(text[2])*(text[1].equals("+")?1:-1);
                                                    
                                                    
            answer[i] = result == Integer.parseInt(text[4])?"O":"X";
        }
        return answer;
    }
}