import java.util.stream.*;

class Solution {
    public String solution(String my_string, String alp) {
        return Stream.of(my_string.split("")).map(str -> str.equals(alp)?str.toUpperCase():str).collect(Collectors.joining());
    }

}