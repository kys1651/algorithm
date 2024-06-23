import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lis = new int[N];
        int idx = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (i == 0) {
                lis[idx++] = value;
            } else {
                if (lis[idx - 1] < value) {
                    lis[idx++] = value;
                } else if (lis[0] > value) {
                    lis[0] = value;
                } else {
                    lis[search(value, idx - 1, lis)] = value;
                }
            }
        }
        System.out.println(idx);
    }

    private static int search(int key, int r, int[] lis) {
        int l = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (lis[mid] > key) r = mid - 1;
            else if (lis[mid] < key) l = mid + 1;
            else return mid;
        }
        return l;
    }
}