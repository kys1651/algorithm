class Solution {
    public String solution(String polynomial) {
        int xCount = 0;
        int num = 0;
        for(String n:polynomial.split(" ")){
            if(n.contains("x")){ 
                xCount += n.equals("x")?1:Integer.parseInt(n.replace("x",""));
            }else if(!n.equals("+")){
                num += Integer.parseInt(n);
            }   
        }
        String line = "";
        if(xCount > 0){
            if(xCount == 1) line += "x";
            else line += xCount + "x";
            
            if(num > 0) line += " + ";
        }
        if(num > 0) line += num;
        
        
        return line;
    }
}