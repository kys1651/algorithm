import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        return Arrays.stream(myString.split("x")).filter(i -> !i.equals("")).sorted().toArray(String[]::new);
    }
}