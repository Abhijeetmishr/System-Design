package Java.Core;

public class EqualsAndHashcode {
    public static class Pair {
        String key;
        int val;

        public Pair(String key, int val){
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString(){
            return "[" + this.key  + ", " + this.val + "]"; 
        }

        public boolean equals(Pair that){
            return this.key.equals(that.key) && this.val == that.val;
        }
    }

    public static void main(String args[]){
        Pair p = new Pair("Bat", 1);
        System.out.println(p.toString());
    }
}
