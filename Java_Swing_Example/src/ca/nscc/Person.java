package ca.nscc;

public abstract class Person {
    private String name;
    private String address;


    public Person() {
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //Name and address string template that will be overridden in the other student and staff classes
    public String toString() {
        return "Name = " + name + ", address = "+ address;
    }
}

