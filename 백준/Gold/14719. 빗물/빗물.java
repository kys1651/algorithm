import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();

        int W = Integer.parseInt(st.nextToken());
        int[] height = new int[W];
        int[] leftHeight = new int[W];
        int[] rightHeight = new int[W];

        // Input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }// Input End

        leftHeight[0] = height[0];
        for (int i = 1; i < W; i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
        }

        rightHeight[W - 1] = height[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(rightHeight[i + 1], height[i]);
        }

        int answer = 0;
        for (int i = 1; i < W - 1; i++) {
            answer += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }
        System.out.println(answer);
    }
}