package DSA.BitManupulation;

/**
 * Toggle middle bit like - 
 * Example 1
 * 111 -> 101
 * Example 2
 * 1111 -> 1001
 */
public class ToggleBit {
    public int toggleTheMiddle(int n)
    {
        int numberOfBits=1+(int)Math.floor(Math.log(n)/Math.log(2)); //finding number of bits
        
        if(numberOfBits%2!=0) { //if bits are odd
            n=n^(1<<(numberOfBits/2)); 
        } else { //else if bits are even
            n=n^(1<<(numberOfBits/2));
            n=n^(1<<((numberOfBits/2)-1));
        }
        return n;
    }
}
