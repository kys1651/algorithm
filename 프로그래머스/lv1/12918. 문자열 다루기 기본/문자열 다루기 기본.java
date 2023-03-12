class Solution {
    public boolean solution(String s) {
        
        return (s.length() - s.replaceAll("[^0-9]","").length()==0)&&((s.length()==4)||s.length()==6);
    }
}