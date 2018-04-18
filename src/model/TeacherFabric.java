package model;

public class TeacherFabric implements PersonFabric {
    @Override
    public Person createPerson(int id, String firstName, String lastName) {
        return new Teacher(id, firstName, lastName);
    }
}
