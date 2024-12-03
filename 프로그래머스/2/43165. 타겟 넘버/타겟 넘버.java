class Solution {
    public int solution(int[] numbers, int target) {
        return solve(0, 0, numbers, target);
    }
    
    private static int solve(int depth, int current, int[] numbers, int target){
        if(depth == numbers.length){
            return current == target ? 1 : 0;
        }    
        return solve(depth + 1, current + numbers[depth], numbers, target) +
            solve(depth + 1, current - numbers[depth], numbers, target);
    }
}