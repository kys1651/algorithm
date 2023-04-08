import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        int num = 1;
        stack.push(num++);
        sb.append("+").append("\n");

        while(num <= n){
            if( !stack.isEmpty() && arr[idx] == stack.peek()){
                sb.append("-").append("\n");
                stack.pop();
                idx++;
            }else{
                stack.push(num++);
                sb.append("+").append("\n");
            }
        }
        while(!stack.isEmpty()){
            if(arr[idx++] == stack.pop())
                sb.append("-").append("\n");
            else {
                break;
            }
        }

        System.out.println(stack.isEmpty()?sb:"NO");

    }
}