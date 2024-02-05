import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] num;
    static String[] oper;
    static boolean[] visit;
    static int result = Integer.MIN_VALUE, numLen, operLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numLen = n / 2 + n % 2;
        operLen = numLen;
        num = new int[numLen];
        visit = new boolean[operLen + 1];
        String input = br.readLine();
        oper = input.split("[0-9]");
        String[] strNum = input.split("[*+-]");
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(strNum[i]);
        }

        combinationOper(1);
        System.out.println(result);
    }

    private static void combinationOper(int depth) {
        if (depth == operLen) {
            int tmp = calc(Arrays.copyOf(num, numLen));
            if (tmp > result) result = tmp;
            return;
        }

        // 앞이 괄호가 아니라면 괄호 만들어주고 넘어감
        if (!visit[depth - 1]) {
            visit[depth] = true;
            combinationOper(depth + 1);
            visit[depth] = false;
        }
        // 괄호 안 씌운 것도 넘겨줌
        combinationOper(depth + 1);


    }

    private static int calc(int[] arr) {
        Queue<Integer> num = new LinkedList<>();
        Queue<String> op = new LinkedList<>();
        for (int i = 0; i < numLen; i++) {
            if (visit[i]) {
                arr[i] = oper(arr[i - 1], arr[i], oper[i]);
                num.add(arr[i]);
            }else{
                if(i != 0) op.add(oper[i]);
                if(i != numLen - 1){
                    if(!visit[i+1]) num.add(arr[i]);
                }else{
                    num.add(arr[i]);
                }
            }
        }

        int tmp = num.poll();
        while (!num.isEmpty()) {
            int nextValue = num.poll();
            String nextOp = op.poll();
            tmp = oper(tmp, nextValue, nextOp);
        }
        return tmp;
    }

    private static int oper(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
        }
        return a;
    }
}

