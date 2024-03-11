package DSA.Math;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static List<Integer> primeFactors(int n){
        List<Integer> factors = new ArrayList<>();
        while(n % 2 == 0){
            factors.add(2);
            n /= 2;
        }
        while(n % 3 == 0){
            factors.add(3);
            n /= 3;
        }

        for(int i = 5; i*i <= n; i = i+6){
            while(n % i == 0){
                factors.add(i);
                n /= i;
            }
            while(n % (i+2) == 0){
                factors.add(i+2);
                n /= (i+2);
            }
        }
        if(n > 3) factors.add(n);
        return factors;
    }

    public static void main(String[] args){
        primeFactors(450).forEach(System.out::println);
    }
}

