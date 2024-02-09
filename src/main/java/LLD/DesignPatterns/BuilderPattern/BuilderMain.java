package LLD.DesignPatterns.BuilderPattern;

public class BuilderMain {
    public static void main(String[] args){
        EnrollmentForm form = new EnrollmentForm
                                .Builder("John", "Doe")
                                .age(25)
                                .gender("Male")
                                .build();

        System.out.println(form.toString());
    }
}
