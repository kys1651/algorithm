class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        int p = s.length() - s.replaceAll("p","").length();
        int y = s.length() - s.replaceAll("y","").length();

        return p==y;
    }
}