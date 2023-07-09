import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int [] x = new int[10];
        int [] y = new int[10];
        
        for(int i = 0 ; i < X.length(); i++){
            x[X.charAt(i) - '0'] += 1;
        }
        for(int i = 0 ; i < Y.length(); i++){
            y[Y.charAt(i) - '0'] += 1;
        }
        
        for(int i = 9; i >= 0; i--){
            for(int j = 0; j < Math.min(x[i],y[i]); j++){
                sb.append(i);
            }
        }
        
        if("".equals(sb.toString())){
            return "-1";
        }else if(sb.toString().charAt(0) == '0'){
            return "0";
        }else{
            return sb.toString();
        }
    }
}