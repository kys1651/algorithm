import java.util.Scanner;

class Main
{
    static class Egg{
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
    static Egg[] eggs;
    static int n,result;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        eggs = new Egg[n];
        for(int i = 0; i < n; i++){
            eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
        }
        result = 0;
        go(0,0);
        System.out.println(result);
    }
    private static void go(int depth, int count) {
        if(depth == n){
            result = Math.max(result, count);
            return;
        }

        Egg e = eggs[depth];
        // 손에 쥔 계란이 깨져있을 때 or 다른 모든 계란이 깨졌을 때
        if(e.durability <= 0 || count == n - 1){
            go(depth + 1,count);
            return;
        }

        int originCount = count;
        for(int i = 0; i < n; i++){
            // 자기 자신의 계란이거나 보고 있는 계란이 깨져있을 때 skip
            if( i == depth || eggs[i].durability <= 0){
                continue;
            }
            // 깰 수 있는 계란일 때
            e.durability -= eggs[i].weight;
            eggs[i].durability -= e.weight;
            // 손에 들고 있는 계란이 깨졌을 때
            if(e.durability <= 0){
                count++;
            }
            // 때린 계란이 깨졌을 때
            if(eggs[i].durability <= 0){
                count++;
            }

            // 다음 계란으로 넘어가기
            go(depth + 1, count);

            e.durability += eggs[i].weight;
            eggs[i].durability += e.weight;
            count = originCount;
        }
    }
}