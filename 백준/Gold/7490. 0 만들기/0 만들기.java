import java.util.*;
import java.io.*;

class Main {
    static ArrayList<String> answer = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            ArrayList<String> list = new ArrayList<>();
            list.add("1");
            solve(2, list);
            answer.add("\n");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : answer) {
            sb.append(s);
        }
        System.out.println(sb);
    }

    private static void solve(int count, ArrayList<String> command) {
        if (count == N + 1) {
            if(calc(command)){
                addAnswer(command);
            }
            return;
        }
        String value = count + "";

        command.add(" ");
        command.add(value);
        solve(count + 1, command);
        command.remove(command.size() - 1);
        command.remove(command.size() - 1);

        command.add("+");
        command.add(value);
        solve(count + 1, command);
        command.remove(command.size() - 1);
        command.remove(command.size() - 1);

        command.add("-");
        command.add(value);
        solve(count + 1, command);
        command.remove(command.size() - 1);
        command.remove(command.size() - 1);
    }

    private static void addAnswer(ArrayList<String> command) {
        StringBuilder sb = new StringBuilder();
        for (String s : command) {
            sb.append(s);
        }
        sb.append('\n');
        answer.add(sb.toString());
    }

    private static boolean calc(ArrayList<String> command) {

        int prev = 0;

        Queue<Integer> number = new LinkedList<>();
        Queue<String> operator = new LinkedList<>();
        for(String c : command){
            if(c.equals("+") || c.equals("-")){
                number.add(prev);
                prev = 0;
                operator.add(c);
            } else if (c.equals(" ")) {
                prev *= 10;
            } else{
                prev += Integer.parseInt(c);
            }
        }
        if(prev != 0) number.add(prev);

        int answer = number.poll();
        while(!number.isEmpty()){
            int value = number.poll();
            String op = operator.poll();
            if (op.equals("+")) {
                answer += value;
            }else{
                answer -= value;
            }
        }
        return answer == 0;
    }
}