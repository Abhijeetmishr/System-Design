package DSA.Math;

public class CountDigits {
    static int countDigit(long n){
        if(n/10 == 0)  
            return 1;
        return 1 + countDigit(n/10);
    }

    public static void main(String[] args){
        long n = 345289467;
        System.out.println("Number of digits: " + countDigit(n));
    }
}
