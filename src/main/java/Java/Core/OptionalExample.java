package Java.Core;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args){
        Optional<String> optional = Optional.ofNullable("Is not null");
        System.out.println(optional.isPresent());

        String res = optional.orElse("Is null");
        System.out.println(res);
    }
}
