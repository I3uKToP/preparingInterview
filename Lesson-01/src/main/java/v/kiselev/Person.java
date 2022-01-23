package v.kiselev;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;


    public static PersonBuilder createPerson() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private final Person person;

        private PersonBuilder() {
            this.person = new Person();
        }

        public PersonBuilder firstName(String firstName) {
            this.person.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.person.lastName = lastName;
            return this;
        }

        public PersonBuilder middleName(String middleName) {
            this.person.middleName = middleName;
            return this;
        }

        public PersonBuilder country(String country) {
            this.person.country = country;
            return this;
        }

        public PersonBuilder address(String address) {
            this.person.address = address;
            return this;
        }

        public PersonBuilder age(int age) {
            this.person.age = age;
            return this;
        }

        public PersonBuilder gender(String gender) {
            this.person.gender = gender;
            return this;
        }

        public Person build() {
            return  this.person;
        }
    }
}
