class Solution {
    class Fractional{
        private int numerator;
        private int denominator;

        public Fractional(int numerator, int denominator){
            this.numerator = numerator;
            this.denominator = denominator;
            normalization();
        }
        public int getNumerator(){
            return numerator;
        }
        
        public int getDenominator(){
            return denominator;
        }
        
        public Fractional add(Fractional other){
            return new Fractional(this.numerator * other.getDenominator() + other.getNumerator() * this.denominator
                                  , this.denominator * other.getDenominator());
        }
        
        private void normalization(){
            int value = GCD();
            numerator /= value;
            denominator /= value;
        }
        
        private int GCD(){
            int min = Math.min(numerator,denominator);
            int max = Math.max(numerator,denominator);
            while(min != 0){
                int tmp = min;
                min = max % min;
                max = tmp;
            }
            
            return max;
        }
    }
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        Fractional a = new Fractional(numer1, denom1);
        Fractional b = new Fractional(numer2, denom2);
        
        Fractional c = a.add(b);
        return new int[] {c.getNumerator(), c.getDenominator()};
        
    }
}