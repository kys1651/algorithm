import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String bomb = br.readLine();
        // bomb.length()는 많이 쓰이기 때문에 bombLen 변수로 만들어준다.
        int bombLen = bomb.length();

        // 값을 넣어줄 stack
        Stack<Character> stack = new Stack<>();
        for (char ch : word.toCharArray()) {
            // 들어온 ch를 push
            stack.push(ch);
            // ch사이즈가 bombWord보다 같거나 크면 bombCheck메서드 실행
            if (stack.size() >= bombLen && bombCheck(stack, bomb,bombLen)) {
                // 만약 bomb단어가 있다면 bomb길이만큼 폭탄을 제거해줌
                for(int i = 0; i < bombLen; i++){
                    stack.pop();
                }
            }
        }

        // iterator방식으로 사용하기 때문에 reverse할 필요없이 바로 삽입해주면 됨
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }

    // stack에 마지막으로 들어온 문자들이 bomb크기만큼 확인 후 같다면 true 다르다면 false
    private static boolean bombCheck(Stack<Character> stack, String bomb, int bombLen) {
        for(int i = 0; i < bombLen; i++){
            if (stack.get(stack.size() - bombLen + i) != bomb.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
