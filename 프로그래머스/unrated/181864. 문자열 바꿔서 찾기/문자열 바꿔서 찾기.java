class Solution {
    public int solution(String myString, String pat) {
        return myString.replaceAll("A","1").replaceAll("B","2").replaceAll("1","B").replaceAll("2","A").contains(pat) == true? 1 : 0;
    }
}