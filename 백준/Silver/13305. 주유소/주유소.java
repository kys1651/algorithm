import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long nodeprice[] = new long[n - 1];//다음 노드로 가는 비용
        long node[] = new long[n];// 노드 당 기름 비용
        int i;
        long sum = 0;

        for (i = 0; i < nodeprice.length; i++) {
            nodeprice[i] = sc.nextInt();
        }
        for (i = 0; i < node.length; i++) {
            node[i] = sc.nextInt();
        }
        long min = node[0];
        for(i = 0 ; i < n; i++){
            if(min < node[i]){
                node[i] = min;
            }
            else{
                min = node[i];
            }
        }

        for(i = 0 ; i < nodeprice.length; i++){
            sum += nodeprice[i] * node[i];
        }


        System.out.println(sum);
    }
}