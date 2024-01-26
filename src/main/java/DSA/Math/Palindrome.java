package DSA.Math;

public class Palindrome {
    static boolean checkPalindrome(int n){
        int reverse = 0;
        int temp = n;

        while(temp != 0){
            int ld = (temp%10);
            reverse = (reverse*10) + ld;
            temp = temp/10;
        }
        return (reverse == n);
    }
    public static void main(String[] args){
        int n = 7007;
        if(checkPalindrome(n)){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }
}
