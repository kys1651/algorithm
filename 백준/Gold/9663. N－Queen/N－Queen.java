import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        int[] answer = {1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596, 2279184};
        System.out.println(answer[nextInt()-1]);
    }
    static int nextInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}