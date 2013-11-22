package Model;

public class Person {
    private String name;
    private Email email;
    private Sex sex;

    public Person(String name, Email email, Sex sex) {
        this.name = name;
        this.email = email;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public Sex getSex() {
        return sex;
    }
    
}
