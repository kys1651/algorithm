import java.util.Scanner;
import java.util.Stack;

class Main {
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();

        while (t-- > 0) {
            int result = 0;
            int n = sc.nextInt();
            arr = new int[n + 1];
            visit = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    result++;
                    checkGraph(i);
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void checkGraph(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[start]);
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            if (!visit[tmp]) {
                visit[tmp] = true;
                stack.push(arr[tmp]);
            }
        }
    }
}
