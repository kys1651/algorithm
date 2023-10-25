import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strings[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strings,(o1,o2)-> (o2+o1).compareTo(o1 + o2));
        if(strings[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for(String string : strings){
            sb.append(string);
        }
        
        return sb.toString();
    }
    
}