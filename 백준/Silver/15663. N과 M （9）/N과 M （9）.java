import java.util.Arrays;
import java.util.Scanner;

class Main
{
    static StringBuilder sb = new StringBuilder();
    static int arr[]; // 출력값들이 저장된 arr배열
    static int num[];
    static boolean visit[];
    static int n,m;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visit = new boolean[n];

        num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
        // 수열은 사전 순으로 증가하는 순서로 출력해야함 그러므로 정렬
        Arrays.sort(num);

        solution(0);

        System.out.println(sb.toString());
    }

    private static void solution(int depth) {
        // depth == m 일 때 배열의 끝까지 간 것임
        if(depth == m){
            for(int num : arr){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        // 방금 출력한 값을 뜻하는 before
        int before = -1;
        for(int i = 0; i < n; i++){
            // i 인덱스를 이미 방문 했거나 방금 배열에 넣은 값인 before와 num[i]가 같다면 continue;
            if(visit[i] || before == num[i]){
                continue;
            }
            arr[depth] = before = num[i];
            visit[i] = true;
            solution(depth+1);
            visit[i] = false;
        }
    }
}