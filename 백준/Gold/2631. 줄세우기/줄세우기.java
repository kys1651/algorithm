import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] LIS = new int[N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			int child = Integer.parseInt(br.readLine());
			if (i == 0) {
				LIS[count++] = child;
			} else {
				if (LIS[count - 1] < child) {
					LIS[count++] = child;
				} else if (LIS[0] > child) {
					LIS[0] = child;
				} else {
					LIS[binary(0, count - 1, LIS, child)] = child;
				}
			}
		}
		
		System.out.println(N - count);
	}

	private static int binary(int left, int right, int[] LIS, int key) {
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(LIS[mid] < key) {
				left = mid+1;
			}else if(LIS[mid] > key) {
				right = mid-1;
			}else {
				return mid;
			}
		}
		return left;
	}
}
