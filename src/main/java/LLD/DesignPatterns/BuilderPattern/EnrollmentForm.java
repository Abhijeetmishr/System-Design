package LLD.DesignPatterns.BuilderPattern;


public class EnrollmentForm {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String gender;

    private EnrollmentForm(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.gender = builder.gender;
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String gender;

        public Builder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder gender(String gender){
            this.gender = gender;
            return this;
        }

        public EnrollmentForm build(){
            return new EnrollmentForm(this);
        }
        
    }

    @Override
    public String toString() {
        return "[firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
                + "]";
    }
}
