import java.io.*;

public class Main {
    private static final String ERROR_WORD = "Error!";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean allLower = true;
        for(char ch : input.toCharArray()) {
            if(Character.isUpperCase(ch) || ch == '_') {
                allLower = false;
                break;
            }
        }
        if (isErrorCheck(input)) {
            System.out.println(ERROR_WORD);
            return;
        }
        if(allLower) {
            System.out.println(input);
            return;
        }

        // C++ -> Java
        if(input.contains("_")){
            System.out.println(cppToJava(input));
        }
        // Java -> C++
        else{
            System.out.println(javaToCpp(input));
        }
    }

    private static String javaToCpp(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(Character.isUpperCase(ch)) {
                sb.append("_").append(Character.toLowerCase(ch));
            }else if(ch == '_'){
                return ERROR_WORD;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private static String cppToJava(String input) {
        StringBuilder sb = new StringBuilder();
        boolean prevUnderBar = false;
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(prevUnderBar){
                if(ch == '_' || Character.isUpperCase(ch)){
                    return ERROR_WORD;
                }else{
                    sb.append(Character.toUpperCase(ch));
                    prevUnderBar = false;
                }
            } else if (ch == '_') {
                prevUnderBar =true;
            } else if(Character.isUpperCase(ch)) {
                return ERROR_WORD;
            } else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private static boolean isErrorCheck(String input) {
        return input.charAt(input.length() - 1) == '_' ||
                Character.isUpperCase(input.charAt(0)) ||
                input.charAt(0) == '_';
    }
}