import java.util.stream.*;

class Solution {
    public String solution(String[] str_list, String ex) {
        return Stream.of(str_list).filter(str -> !str.contains(ex))
            .collect(Collectors.joining());
    }
}