package DSA.Math;

public class GCD {
    //Find greatest common divisor 
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        } else {
            return gcd(b, a%b);
        }
    }
}
