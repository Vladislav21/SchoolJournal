package model;

public class StudentFabric implements PersonFabric {
    @Override
    public Person createPerson(int id, String firstName, String lastName) {
        return new Student(id, firstName, lastName);
    }
}
