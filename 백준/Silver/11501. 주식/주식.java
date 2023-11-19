import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            long result = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int max = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (max < nums[j]) {
                    max = nums[j];
                } else {
                    result += max - nums[j];
                }
            }
            System.out.println(result);
        }
    }
}
