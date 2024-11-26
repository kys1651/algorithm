class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean ineqFlag = ineq.equals(">");
        boolean eqFlag = eq.equals("=");
        return (ineqFlag ? (eqFlag ? n >= m : n > m) : (eqFlag ? n <= m : n < m)) ? 1 : 0;
    }
}