package DSA.Math;

public class NearestPerfectSquare {
    public static boolean isPerfectSquare(long number)
    {
        long root=(long)Math.sqrt(number);
        return root*root==number;
    }
    public long nearestPerfectSquare(long n)
    {
        long smaller;
	    long greater;
	    
	    if(isPerfectSquare(n)==true)
	    {
	        smaller=(long)Math.sqrt(n)-1;
	        greater=(long)Math.sqrt(n)+1;
	    }
	    else
	    {
	        smaller=(long)Math.floor(Math.sqrt(n));
	        greater=(long)Math.ceil(Math.sqrt(n));
	    }
	    
	    if((long)Math.abs(smaller*smaller-n)<(long)Math.abs(greater*greater-n))
	        return(smaller*smaller);
	    else    
            return(greater*greater);
    }
}
